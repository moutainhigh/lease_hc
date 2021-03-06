package com.hc.lease.workflow.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by LJ on 2018/5/4
 */
@Data
public class ActModelSaveDTO implements Serializable {

    private String modelId;

    private String name;

    private String description;

    private String json_xml;

    private String svg_xml;

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getJson_xml() {
        return json_xml;
    }

    public void setJson_xml(String json_xml) {
        this.json_xml = json_xml;
    }

    public String getSvg_xml() {
        return svg_xml;
    }

    public void setSvg_xml(String svg_xml) {
        this.svg_xml = svg_xml;
    }
}
