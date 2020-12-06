package 建造者模式;

import 建造者模式.Producetr.Builder;

/**
 * @author lxy
 * @date 2020/11/22 21:43
 **/
public class Test {

    public static void main(String[] args) {
        Producetr.Builder producetr = new Builder().partmater1("一");
        producetr.partmater2("二").builder();

        System.out.println(producetr);
    }

}

class Producetr {

    private final String partmater1;
    private final String partmater2;
    private final String partmater3;
    private final String partmater4;
    private final String partmater5;
    private final String partmater6;


    public Producetr(String partmater1, String partmater2, String partmater3, String partmater4,
            String partmater5, String partmater6) {
        this.partmater1 = partmater1;
        this.partmater2 = partmater2;
        this.partmater3 = partmater3;
        this.partmater4 = partmater4;
        this.partmater5 = partmater5;
        this.partmater6 = partmater6;
    }


    static class Builder {

        private String partmater1;
        private String partmater2;
        private String partmater3;
        private String partmater4;
        private String partmater5;
        private String partmater6;

        public Builder partmater1(String partmater1) {
            this.partmater1 = partmater1;
            return this;
        }

        public Builder partmater2(String partmater2) {
            this.partmater2 = partmater2;
            return this;
        }

        public Builder partmater3(String partmater3) {
            this.partmater3 = partmater3;
            return this;
        }

        public Builder partmater4(String partmater4) {
            this.partmater4 = partmater4;
            return this;
        }

        public Builder partmater5(String partmater5) {
            this.partmater5 = partmater5;
            return this;
        }

        public Builder partmater6(String partmater6) {
            this.partmater6 = partmater6;
            return this;
        }

        Producetr builder() {
            Producetr producetr = new Producetr(this.partmater1, this.partmater2, this.partmater3, this.partmater4,
                    this.partmater5, this.partmater6);
            return producetr;
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "partmater1='" + partmater1 + '\'' +
                    ", partmater2='" + partmater2 + '\'' +
                    ", partmater3='" + partmater3 + '\'' +
                    ", partmater4='" + partmater4 + '\'' +
                    ", partmater5='" + partmater5 + '\'' +
                    ", partmater6='" + partmater6 + '\'' +
                    '}';
        }
    }
}