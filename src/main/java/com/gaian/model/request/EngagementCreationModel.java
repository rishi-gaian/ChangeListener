package com.gaian.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.gaian.model.request.engagement.ChannelDetails;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class EngagementCreationModel {

    private String name;
    private String description;
    
    public enum Type {
        GROUP, ANALYTICS
    }

    private Source source;
    private Destination destination;
    private Trigger trigger;
    private ChannelDetails channel;

    @Data
    @JsonInclude(Include.NON_NULL)
    public static class Source {
        private Type sourceType;
        private String sourceId;
        // can have static & trigger_attr filter types
        private List<Filter> filters;
        private Iteration iteration;
    }
    
    @Data
    @JsonInclude(Include.NON_NULL)
    public static class Destination {
        
        // TODO
        // destinationType
        // destination can be group or query ??
        
        private Type destinationType;
        private String destinationId;
        private List<Filter> filters;
        private Iteration iteration;
        private String destinationAttribute;
    }

    @Data
    @JsonInclude(Include.NON_NULL)
    public static class Filter {

        public enum FilterType {
            STATIC, SOURCE_ATTR, TRIGGER_ATTR, DEST_ATTR
        }

        private FilterType type;
        private String attribute;
        private Object value;
        // op ?
        // transformer ?
        
        // transformer is applied on value ??
        
    }

    @Data
    @JsonInclude(Include.NON_NULL)
    public static class Iteration {

        public enum IterationType {
            PER_ROW, OVER_ATTRIBUTES, NONE
        }

        private IterationType type = IterationType.NONE;
        private List<String> attributes;
        
    }

}
