package fr.neoxia;


public class AttachmentTest {


   /* private Node node;
    // Client client;
    TransportClient client;
    ESLogger log = Loggers.getLogger(AttachmentTest.class);

    @BeforeClass
    public void setupNode() {
        //node = nodeBuilder().clusterName("marwaNLookerCluster").node();
        //uncomment this client if you want to use an ES already running
        client = new TransportClient().addTransportAddress(new InetSocketTransportAddress("localhost", 9300));
        //client = node.client();
        //   Settings  settings = ImmutableSettings.settingsBuilder()
        //   .put("client.transport.sniff", true).build();
        //client = new TransportClient(settings);
    }

    @Test
    public void mapperAttachmentTest() throws Exception {
        String idxName = "test";
        String idxType = "attachment";
        XContentBuilder map = jsonBuilder().startObject()
                .startObject(idxType)
                .startObject("properties")
                .startObject("file")
                .field("type", "attachment")
                .startObject("fields")
                .startObject("title")
                .field("store", "yes")
                .endObject()
                .startObject("file")
                .field("term_vector","with_positions_offsets")
                .field("store","yes")
                .endObject()
                .endObject()
                .endObject()
                .endObject()
                .endObject();
        try {
            client.admin().indices().prepareDelete(idxName).execute().actionGet();
        } catch (Exception ex) {}

        log.info("create index and mapping");
        CreateIndexResponse resp = client.admin().indices().prepareCreate(idxName).setSettings(
                ImmutableSettings.settingsBuilder()
                        .put("number_of_shards", 1)
                        .put("index.numberOfReplicas", 1))
                .addMapping("attachment", map).execute().actionGet();


        String pdfPath = ClassLoader.getSystemResource("isl99201.pdf").getPath();

        String data64 = org.elasticsearch.common.Base64.encodeFromFile(pdfPath);


        log.info("Indexing");
        XContentBuilder source = jsonBuilder().startObject()
                .field("file", data64).endObject();

        IndexResponse idxResp = client.prepareIndex().setIndex(idxName).setType(idxType).setId("80")
                .setSource(source).setRefresh(true).execute().actionGet();



        String queryString = "amplifier";


        log.info("Searching by "+queryString);
        QueryBuilder query = QueryBuilders.queryString(queryString);

        SearchRequestBuilder searchBuilder = client.prepareSearch().setQuery(query).addField("title").addHighlightedField("file");

        SearchResponse search = searchBuilder.execute().actionGet();
        log.info("result : "+search.toString());
        assertThat(search.getHits().totalHits(),equalTo(1L));
        assertThat(search.getHits().hits().length, equalTo(1));
        assertThat(search.getHits().getAt(0).highlightFields().get("file"),notNullValue());
        assertThat(search.getHits().getAt(0).highlightFields().get("file").toString(), containsString("<em>Amplifier</em>"));

        client.close();
    }
*/

}
