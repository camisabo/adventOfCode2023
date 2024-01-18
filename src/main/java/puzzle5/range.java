/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle5;

/**
 *
 * @author Omar Nicolas Guerrero
 */
public class range {
    private long firstElement;
    private long lastElement;

    public range(long firstElement, long lastElement) {
        this.firstElement = firstElement;
        this.lastElement = lastElement;
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
    
    
}
