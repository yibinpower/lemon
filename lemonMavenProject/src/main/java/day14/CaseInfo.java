package day14;

import cn.afterturn.easypoi.excel.annotation.Excel;

/**
 * @Author: YiBin
 * @Description: 实体类封装，对应着excel用例字段
 * @Date: Created in 下午 03:20 20/05/15
 * @Modified By:
 */
public class CaseInfo {
    @Excel(name="CaseId(用例编号)")
    private int caseId;
    @Excel(name="Name(接口名)")
    private String name;
    @Excel(name="Url(接口地址)")
    private String url;
    @Excel(name="Type(接口提交类型)")
    private String type;
    @Excel(name="Desc(用例描述)")
    private String desc;
    @Excel(name="Params(参数)")
    private String params;
    @Excel(name="Content-Type")
    private String contentType;

    public CaseInfo() {
    }

    public CaseInfo(int caseId, String name, String url, String type, String desc, String params, String contentType) {
        this.caseId = caseId;
        this.name = name;
        this.url = url;
        this.type = type;
        this.desc = desc;
        this.params = params;
        this.contentType = contentType;
    }

    public int getCaseId() {
        return caseId;
    }

    public void setCaseId(int caseId) {
        this.caseId = caseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
}
