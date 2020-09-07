package xilalu.entity;

/**
 * 数字对象.
 */
public class NumObj {
    private Double start;
    private Double end;

        public NumObj(Double start, Double end) {
            this.start = start;
            this.end = end;
        }

    public Double getStart() {
        return start;
    }

    public void setStart(Double start) {
        this.start = start;
    }

    public Double getEnd() {
        return end;
    }

    public void setEnd(Double end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "NumObj{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}