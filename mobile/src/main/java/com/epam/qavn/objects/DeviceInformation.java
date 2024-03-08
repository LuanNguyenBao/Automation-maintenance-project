package com.epam.qavn.objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

@JsonPropertyOrder({ "name", "platformName", "platformVersion", "udid"})
public class DeviceInformation {

    private String name;
    private String platformName;
    private String platformVersion;
    private String udid;

    public DeviceInformation(JsonObject jsonObject) {
        Gson gson = new Gson();
        this.name = gson.fromJson(jsonObject, DeviceInformation.class).getName();
        this.platformName = gson.fromJson(jsonObject, DeviceInformation.class).getPlatformName();
        this.platformVersion = gson.fromJson(jsonObject, DeviceInformation.class).getPlatformVersion();
        this.udid = gson.fromJson(jsonObject, DeviceInformation.class).getUDID();
    }

    @JsonProperty("name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getName() {
        return name;
    }

    @JsonProperty("platformName")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getPlatformName() {
        return platformName;
    }

    @JsonProperty("platformVersion")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getPlatformVersion() {
        return platformVersion;
    }

    @JsonProperty("udid")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getUDID() {
        return udid;
    }
}
