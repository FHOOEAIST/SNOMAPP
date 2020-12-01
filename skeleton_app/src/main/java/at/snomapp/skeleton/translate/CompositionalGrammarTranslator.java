package at.snomapp.skeleton.translate;

import at.snomapp.skeleton.domain.conceptMapping.impl.SNOMEDElement;

public class CompositionalGrammarTranslator {
    private SNOMEDElement modality;
    private SNOMEDElement laterality;
    private SNOMEDElement procedures;
    private SNOMEDElement anatomy;

    private static final String ROOT = "302199004 |Examination|";
    private static final String MODALITY_KEY = "260686004 |Method (attribute)|";
    private static final String LATERALITY_KEY = "272741003 |Laterality|";
    private static final String PROCEDURES_KEY = "260686004 |Method (attribute)|";
    private static final String ANATOMY_KEY = "123037004 |Body structure|";

    public String getCompositionalRepresentation(){
        StringBuilder sb = new StringBuilder();

        // Root element to be restricted
        sb.append(ROOT).append(":\n");

        // Modality
        if( modality != null) {
            sb.append(" ").append(MODALITY_KEY).append(" = ")
                    .append(modality.getCode())
                    .append(" |").append(modality.getDisplayName()).append("|");
        }

        // Laterality
        if(laterality != null) {
            sb.append(",\n")
                    .append(" ").append(LATERALITY_KEY).append(" = ")
                    .append(laterality.getCode())
                    .append(" |").append(laterality.getDisplayName()).append("|");
        }

        // Procedure
        if(procedures != null) {
            sb.append(",\n")
                    .append(" ").append(PROCEDURES_KEY).append(" = ")
                    .append(procedures.getCode())
                    .append(" |").append(procedures.getDisplayName()).append("|");
        }

        // Anatomy
        if(anatomy != null) {
            sb.append(",\n")
                    .append(" ").append(ANATOMY_KEY).append(" = ")
                    .append(anatomy.getCode())
                    .append(" |").append(anatomy.getDisplayName()).append("|");
        }

        return sb.toString();
    }

    public void setModality(SNOMEDElement modality) {
        this.modality = modality;
    }

    public void setLaterality(SNOMEDElement laterality) {
        this.laterality = laterality;
    }

    public void setProcedures(SNOMEDElement procedures) {
        this.procedures = procedures;
    }

    public void setAnatomy(SNOMEDElement anatomy) {
        this.anatomy = anatomy;
    }
}
