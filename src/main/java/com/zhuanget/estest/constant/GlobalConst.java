package com.zhuanget.estest.constant;

import com.zhuanget.estest.entity.SimpleBook;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author Zhuang_ET
 * @since 2020-09-29 16:04:33
 */
public class GlobalConst {

    private GlobalConst() {}

    public static final String VERSION = "0.1.0";

    public static final String BIGDATA_ARCHIVE_INDEX = "bigdata_archive";

    public static final String BIGDATA_ARCHIVE_TYPE = "bigdata_archive";

    public static final String SIMPLE_BOOK_INDEX = "simple_book";

    public static final String SIMPLE_BOOK_TYPE = "simple_book";

    public static final String NORMAL_SETTINGS = "{\n" +
            "    \"settings\": {\n" +
            "        \"index\": {\n" +
            "            \"number_of_shards\": \"1\",\n" +
            "            \"number_of_replicas\": \"0\"\n" +
            "        }\n" +
            "    }\n" +
            "}";

    public static final String SIMPLE_BOOK_SETTINGS = "{\n" +
            "    \"settings\": {\n" +
            "        \"index\": {\n" +
            "            \"number_of_shards\": \"1\",\n" +
            "            \"analysis\": {\n" +
            "                \"analyzer\": {\n" +
            "                    \"ik_syno\": {\n" +
            "                        \"type\": \"custom\",\n" +
            "                        \"tokenizer\": \"ik_smart\"\n" +
            "                    },\n" +
            "                    \"ik_syno_max\": {\n" +
            "                        \"type\": \"custom\",\n" +
            "                        \"tokenizer\": \"ik_max_word\"\n" +
            "                    }\n" +
            "                }\n" +
            "            },\n" +
            "            \"number_of_replicas\": \"0\"\n" +
            "        }\n" +
            "    }\n" +
            "}";

    public static final String SIMPLE_BOOK_MAPPINGS = "{\n" +
            "    \"properties\": {\n" +
            "        \"id\": {\n" +
            "            \"type\": \"keyword\"\n" +
            "        },\n" +
            "        \"name\": {\n" +
            "            \"type\": \"text\",\n" +
            "            \"analyzer\": \"ik_syno_max\",\n" +
            "            \"search_analyzer\": \"ik_syno\"\n" +
            "        },\n" +
            "        \"image_url\": {\n" +
            "            \"type\": \"keyword\",\n" +
            "            \"index\": false\n" +
            "        },\n" +
            "        \"user\": {\n" +
            "            \"type\": \"text\",\n" +
            "            \"analyzer\": \"ik_syno_max\",\n" +
            "            \"search_analyzer\": \"ik_syno\"\n" +
            "        },\n" +
            "        \"user_home\": {\n" +
            "            \"type\": \"text\",\n" +
            "            \"analyzer\": \"ik_syno_max\",\n" +
            "            \"search_analyzer\": \"ik_syno\"\n" +
            "        },\n" +
            "        \"create_time\": {\n" +
            "            \"type\": \"date\",\n" +
            "            \"format\": \"yyyy-MM-dd HH:mm:ss\"\n" +
            "        },\n" +
            "        \"update_time\": {\n" +
            "            \"type\": \"date\",\n" +
            "            \"format\": \"yyyy-MM-dd HH:mm:ss\"\n" +
            "        }\n" +
            "    }\n" +
            "}";

    public static final BlockingQueue<SimpleBook> SIMPLE_BOOK_BATCH_QUEUE = new LinkedBlockingDeque<>(4096);
}
