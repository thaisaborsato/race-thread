public class Route {

    private Integer finalStep;
    private Integer boundStep;

    public Route(Integer boundStep, Integer finalStep) {
        this.finalStep = finalStep;
        this.boundStep = boundStep;
    }

    public Integer getFinalStep() {
        return finalStep;
    }

    public void setFinalStep(Integer finalStep) {
        this.finalStep = finalStep;
    }

    public Integer getBoundStep() {
        return boundStep;
    }

    public void setBoundStep(Integer boundStep) {
        this.boundStep = boundStep;
    }
}
