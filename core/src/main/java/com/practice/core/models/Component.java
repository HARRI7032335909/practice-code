package com.practice.core.models;
import org.osgi.annotation.versioning.ConsumerType;

import com.adobe.cq.export.json.ComponentExporter;
import com.practice.core.models.ComponentDataModelSerializer;
import com.adobe.cq.wcm.core.components.models.datalayer.ComponentData;
import com.drew.lang.annotations.NotNull;
import com.drew.lang.annotations.Nullable;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;


@ConsumerType
public interface Component extends ComponentExporter {

   
    String PN_ID = "id";

   
    @Nullable
    default String getId() {
        return null;
    }

   
    @Nullable
    @JsonProperty("dataLayer")
    @JsonSerialize(using = ComponentDataModelSerializer.class)
    default ComponentData getData() {
        return null;
    }

    
    @Nullable
    @JsonProperty("appliedCssClassNames")
    default String getAppliedCssClasses() {
        return null;
    }

    /**
     * @see ComponentExporter#getExportedType()
     * @since com.adobe.cq.wcm.core.components.models 12.8.0
     */
    @NotNull
    @Override
    default String getExportedType() {
        return "";
    }

}
