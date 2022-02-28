package uri.dam.tresper.models;

import java.util.List;

public class ClassiElement {


    List<Ronda> rondes;

    public ClassiElement(List<Ronda> rondes) {
        this.rondes = rondes;
    }

    public List<Ronda> getRondes() {
        return rondes;
    }
}
