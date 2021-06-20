package ru.job4j.stream;

public class AtmModel {
    private String name;
    private boolean moneyReceiving;
    private float height;
    private float width;
    private int numberOfCassettes;

    static class Builder {
        private String name;
        private boolean moneyReceiving;
        private float height;
        private float width;
        private int numberOfCassettes;

        Builder buildName(String name) {
            this.name = name;
            return this;
        }

        Builder buildMoneyReceiving(boolean moneyReceiving) {
            this.moneyReceiving = moneyReceiving;
            return this;
        }

        Builder buildHeight(float height) {
            this.height = height;
            return this;
        }

        Builder buildWidth(float width) {
            this.width = width;
            return this;
        }

        Builder buildNumberOfCassettes(int numberOfCassettes) {
            this.numberOfCassettes = numberOfCassettes;
            return this;
        }

        AtmModel build() {
            AtmModel atmModel = new AtmModel();
            atmModel.name = name;
            atmModel.moneyReceiving = moneyReceiving;
            atmModel.height = height;
            atmModel.width = width;
            atmModel.numberOfCassettes = numberOfCassettes;
            return atmModel;
        }
    }

    @Override
    public String toString() {
        return "AtmModel{"
                + "name='"
                + name
                + '\''
                + ", moneyReceiving="
                + moneyReceiving
                + ", height="
                + height
                + ", width="
                + width
                + ", numberOfCassettes="
                + numberOfCassettes
                + '}';
    }

    public static void main(String[] args) {
        AtmModel atmModel = new Builder().buildName("Wincor")
                .buildMoneyReceiving(true)
                .buildHeight(198.14f)
                .buildWidth(85.54f)
                .buildNumberOfCassettes(5)
                .build();
        System.out.println(atmModel);
    }
}
