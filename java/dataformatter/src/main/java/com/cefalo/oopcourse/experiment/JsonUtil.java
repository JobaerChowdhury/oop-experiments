package com.cefalo.oopcourse.experiment;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.List;

public class JsonUtil {
    public static String fromItemList(List<Item> items) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode root = mapper.createObjectNode();
        ArrayNode resultNode = mapper.createArrayNode();

        for (Item item : items) {
            ObjectNode itemNode = mapper.createObjectNode();
            itemNode.put("id", item.getId());
            itemNode.put("title", item.getTitle());
            itemNode.put("value", item.getValue());
            resultNode.add(itemNode);
        }

        root.set("result", resultNode);
        return mapper.writeValueAsString(root);
    }
}
