package tdd.money;

import java.util.Hashtable;

public class Bank {

    private Hashtable rates = new Hashtable();
    private Pair pair;

    public Money reduce(Expression source, String to) {
        return source.reduce(this, to);
    }

    public void addRate(String from, String to, int rate) {
        pair = new Pair(from, to);
        rates.put(pair, new Integer(rate));
    }

    public int rate(String from, String to){
        if(from.equals(to)) return 1;
        Integer rate = (Integer) rates.get(pair);
         return rate.intValue();
    }

    private class Pair {
        private String from;
        private String to;

        public Pair(String from, String to){
            this.from = from;
            this.to = to;
        }

        public boolean equals(Object obj) {
            Pair pair = (Pair) obj;
            return from.equals(pair.from) && to.equals(pair.to);
        }

        public int hashcode(){
            return 0;
        }
    }
}


