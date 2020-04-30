package com.changgou.spring.es.bean;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * 创建映射信息
 * @Document 文档对象(索引信息、文档类型)
 * @Id 映射文档id
 * @Field(
 *   type = 数据类型,
 *   analyzer = 索引时使用的分词器,
 *   searchAnalyzer = (查询时使用的分词器，可以省略，默认与analyzer一样),
 *   index = 是否索引，默认值true,
 *   store = 是否存储，默认false ,Elasticsearch默认使用_source存放我们数据内容
 *  )
 */
@Document(indexName = "blog1",type = "article")
public class Article {
    @Id
    private Long id;
    @Field(type = FieldType.Text,analyzer = "ik_smart",searchAnalyzer = "ik_smart",index = true,store = false)
    private String title;
    @Field(type = FieldType.Text,analyzer = "ik_smart",searchAnalyzer = "ik_smart",index = true,store = false)
    private String content;

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Article() {
    }

    public Article(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }
}
