package ${basePackage}.model;

import lombok.Data;

@Data
public class DataModel {

<#list modelConfig.models as model >
    /**
    * ${model.description}
    */
    private ${model.type} ${model.fieldName} <#if model.defaultValue??> = ${model.defaultValue?c} </#if>;
</#list>
}