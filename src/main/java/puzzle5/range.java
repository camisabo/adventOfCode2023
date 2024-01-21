/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle5;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Omar Nicolas Guerrero
 */
public class Range {
    private long firstElement;
    private long lastElement;

    public Range(long firstElement, long lastElement) {
        this.firstElement = firstElement;
        this.lastElement = lastElement;
    }

    public Range(long firstElement) {
        this.firstElement = firstElement;
    }
    
    

    public long getFirstElement() {
        return firstElement;
    }

    public void setFirstElement(long firstElement) {
        this.firstElement = firstElement;
    }

    public long getLastElement() {
        return lastElement;
    }

    public void setLastElement(long lastElement) {
        this.lastElement = lastElement;
    }
    
    private boolean inMiddle (long evaluateElement, Range rangeToFindElement){
        long rangeFirstElement = rangeToFindElement.getFirstElement();
        long rangeLastElement = rangeToFindElement.getLastElement();
        return (rangeFirstElement <= evaluateElement && evaluateElement <= rangeLastElement);
    }
    
    public ArrayList<Range> overlap (Range otherRange){
        ArrayList<Range> ranges = null;
        long otherRangeFirstElement = otherRange.getFirstElement();
        long otherRangeLastElement = otherRange.getLastElement();
        long[] medidas = {otherRangeFirstElement, otherRangeLastElement, firstElement, lastElement};
        boolean itsStart = false;
        Arrays.sort(medidas);
        for (int i = 0; i < 2; i++) {
            if (!itsStart && firstElement == medidas[i]) {
                itsStart = true;
                Range newRange = new Range(medidas[i], medidas[i+1]);
                ranges.add(newRange);
            }else if (itsStart) {
                Range newRange = new Range(medidas[i], medidas[i+1]);
                ranges.add(newRange);
            }
            if (itsStart && medidas[i+1] == lastElement) {
                break;
            }
        }
        if (ranges.size()>1) {
            for (int i = 0; i < ranges.size()-1; i++) {
                Range range = ranges.get(i);
                range.setLastElement(range.getLastElement()-1);
            }
        }
        return ranges;
    }
    
}
