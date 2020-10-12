package at.snomapp.skeleton.domain.appc;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import netscape.javascript.JSObject;

import java.util.*;

public class APPCTree  {
    private final String language;

    public String getLanguage() {
        return language;
    }

    public void setModality(AxisEntry modality) {
        this.modality = modality;
    }

    public void setLaterality(AxisEntry laterality) {
        this.laterality = laterality;
    }

    public void setProcedure(AxisEntry procedure) {
        this.procedure = procedure;
    }

    public void setAnatomy(AxisEntry anatomy) {
        this.anatomy = anatomy;
    }

    private AxisEntry modality;
    private AxisEntry laterality;
    private AxisEntry procedure;
    private AxisEntry anatomy;

    public APPCTree(String language){
        this.language = language;
        modality = null;
        laterality = null;
        procedure = null;
        anatomy = null;
    }

    // primitive search functionality, returns exact matches only
    public Set<Entry> search(String query){
        Set<Entry> result = new HashSet<>();
        result.addAll(modality.search(query));
        result.addAll(laterality.search(query));
        result.addAll(procedure.search(query));
        result.addAll(anatomy.search(query));

        return result;
    }

    @Override
    public String toString() {
        return "APPCTree{" +
                "language='" + language + '\'' +
                "\n modality=" + modality +
                "\n laterality=" + laterality +
                "\n procedure=" + procedure +
                "\n anatomy=" + anatomy +
                '}';
    }

    public Iterable<Entry> getRoots(){
        Set<Entry> set = new HashSet<>();
        set.add(laterality);
        set.add(modality);
        set.add(procedure);
        set.add(anatomy);

        return set;
    }

    public AxisEntry getAnatomy() {
        return anatomy;
    }

    public AxisEntry getModality() {
        return modality;
    }

    public AxisEntry getProcedure (){
        return procedure;
    }

    public AxisEntry getLaterality(){
        return laterality;
    }



    // build json tree out of entry
    public JSONObject entryToJsonString (Entry entry){
        if (entry == null) {
            return null;
        }

        LinkedHashMap<String, Object> map = new LinkedHashMap();

        // array which contains all children of a node
        JSONArray array = new JSONArray();
        if (entry.getChildren() != null) {
            for (Entry children : entry.getChildren()) {
                JSONObject subChildren = entryToJsonString(children);
                if (subChildren != null) {
                    array.add(subChildren);
                }
            }
        }

        // text element in each node
        // TODO: 06.10.2020 hacky way of getting the id of a code to frontend: consider alternatives
        map.put("text", "APPC " + entry.getCode() + " " + entry.getDisplayName()
                + "<div style=\"display:none\">" + entry.getId() + "</div>");

        // nodes element in nodes which have children
        if (array.size() > 0){
            map.put("nodes", array);
        }
        return new JSONObject(map);
    }

    // build json tree out of axis
    private JSONArray axisToJsonString(Set<Entry> axis){
        JSONArray jsonArray = new JSONArray();
        // iterate over all axis and build json tree for all axis
        for (Entry entry : axis){
            jsonArray.add(entryToJsonString(entry));
        }
        return jsonArray;
    }


    public String getAnatomyJsonString () {
        return axisToJsonString(this.getAnatomy().getChildren()).toJSONString();
    }

    public String getModalityJsonString () {
        return axisToJsonString(this.getModality().getChildren()).toJSONString();
    }

    public String getProcedureJsonString () {
        return axisToJsonString(this.getProcedure().getChildren()).toJSONString();
    }

    public String getLateralityJsonString () {
        return axisToJsonString(this.getLaterality().getChildren()).toJSONString();
    }
}
