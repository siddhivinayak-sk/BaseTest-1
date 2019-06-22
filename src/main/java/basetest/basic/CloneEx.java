/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basetest.basic;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sandeep.kumar
 */
class CLP implements Cloneable {
    private Integer clpId;
    private String clpName;

    public CLP() {
    }

    public CLP(Integer clpId, String clpName) {
        this.clpId = clpId;
        this.clpName = clpName;
    }

    public Integer getClpId() {
        return clpId;
    }

    public void setClpId(Integer clpId) {
        this.clpId = clpId;
    }

    public String getClpName() {
        return clpName;
    }

    public void setClpName(String clpName) {
        this.clpName = clpName;
    }

    @Override
    public String toString() {
        return "CLP{" + "clpId=" + clpId + ", clpName=" + clpName + '}';
    }
    
    public CLP clone() throws CloneNotSupportedException {
        return (CLP)clone();
    }
}

class CLC implements Cloneable {
    private Integer clcId;
    private String clcName;
    private List<CLP> clpList;

    public CLC() {
    }

    public CLC(Integer clcId, String clcName, List<CLP> clpList) {
        this.clcId = clcId;
        this.clcName = clcName;
        this.clpList = clpList;
    }

    public Integer getClcId() {
        return clcId;
    }

    public void setClcId(Integer clcId) {
        this.clcId = clcId;
    }

    public String getClcName() {
        return clcName;
    }

    public void setClcName(String clcName) {
        this.clcName = clcName;
    }

    public List<CLP> getClpList() {
        return clpList;
    }

    public void setClpList(List<CLP> clpList) {
        this.clpList = clpList;
    }
    
    public CLC getCopy() throws CloneNotSupportedException {
        return (CLC)this.clone();
    }

    @Override
    public String toString() {
        return "CLC{" + "clcId=" + clcId + ", clcName=" + clcName + ", clpList=" + clpList + '}';
    }
    
    
}

public class CloneEx {
    public static void main(String...args) throws Exception {
        List<CLP> clpList = new ArrayList<CLP>();
        clpList.add(new CLP(1, "A"));
        clpList.add(new CLP(2, "B"));
        clpList.add(new CLP(3, "C"));
        clpList.add(new CLP(4, "D"));
        clpList.add(new CLP(5, "E"));
        CLC clc1 = new CLC(101, "CLC1", clpList);
        System.out.println(clc1.hashCode());
        System.out.println(clc1.getClpList().hashCode());

        System.out.println("______________________________________________");
        CLC clc2 = clc1.getCopy();
        System.out.println(clc2);
        System.out.println(clc2.hashCode());
        System.out.println(clc2.getClpList().hashCode());
    }
}
