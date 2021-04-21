package com.company;

public class Nurse {
    private String creator;
    private int breakT;
    private String description;
    private String start;
    private String end;
    public String ShiftType;

    public Nurse() {
    }

    public Nurse(String creator, int breakT, String description, String start, String end, String shiftType) {//builds a Nurse object
        this.creator = creator;
        this.breakT = breakT;
        this.description = description;
        this.start = start;
        this.end = end;
        this.ShiftType = shiftType;

    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    } //adds the creator object into a string value for use in printing

    public int getBreakT() {
        return breakT;
    }

    public void setBreakT(int breakT) {this.breakT = breakT;}//adds the breakT object into a string value for use in printing

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }//adds the Description object into a string value for use in printing

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }//adds the start object into a string value for use in printing

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }//adds the end object into a string value for use in printing

    public String getShiftType() {
            return ShiftType;
    }

    public void setShiftType(String shiftType) {
        this.ShiftType = shiftType;//adds the shiftType object into a string value for use in printing
    }

    @Override
    public String toString() {

        String Output = "Nurse [creator=" + creator + "\\n" + " , break=" + breakT + "\\n" + ", description=" + description + "\\n" + ", start=" + start + "\\n" +  ", end=" + end + "\\n" +  ", shift type=" + ShiftType + "]" + "\\n";
            return Output;

    }

}