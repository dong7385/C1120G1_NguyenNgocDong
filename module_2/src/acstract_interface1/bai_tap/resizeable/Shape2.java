package acstract_interface1.bai_tap.resizeable;

public class Shape2 {
    private String color = "green";
    private boolean filled = true;

    public Shape2() {
    }

    public Shape2(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    @Override
    public String toString() {
        return "\"A Shape with color of" + getColor()
                + "and" + (isFilled() ? "filled" : "not filled");
    }


}

