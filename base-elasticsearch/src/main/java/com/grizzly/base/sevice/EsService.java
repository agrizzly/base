package com.grizzly.base.sevice;


import com.alibaba.fastjson.JSON;
import com.grizzly.base.pojo.Content;
import com.grizzly.base.utils.HtmlParseUtil;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class EsService {

    @Autowired
    @Qualifier("restHighLevelClient")
    private RestHighLevelClient client;

    public void testSave(String saveword) throws IOException {
        List<Content> list = new HtmlParseUtil().parseJD(saveword);
        BulkRequest bulkRequest = new BulkRequest();
        bulkRequest.timeout("10s");
        for (int i=0;i<list.size();i++){
            bulkRequest.add(new IndexRequest("wxf2").source(JSON.toJSONString(list.get(i)), XContentType.JSON));
        }
        BulkResponse response = client.bulk(bulkRequest, RequestOptions.DEFAULT);
        System.out.println(response);
    }

    public List<Map<String,Object>> testShow(String keyword) throws IOException {
        SearchRequest searchRequest = new SearchRequest("wxf2");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        //分页
        searchSourceBuilder.from(0).size(20);

        //精准查询
//        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("title", keyword);

        //模糊查询
        MatchQueryBuilder query = QueryBuilders.matchQuery("title", keyword);
        searchSourceBuilder.query(query);


        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.field("title").preTags("<span style='color:red'>").postTags("</span>");
        searchSourceBuilder.highlighter(highlightBuilder);

        //执行搜索
        searchRequest.source(searchSourceBuilder);
        SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
        ArrayList<Map<String,Object>> list = new ArrayList<>();
        for (SearchHit documentFields: response.getHits().getHits()){
            list.add(documentFields.getSourceAsMap());
        }
        return list;
    }
}
