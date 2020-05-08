 public int findRadius(int[] houses, int[] heaters) {
        TreeSet<Integer> set=new TreeSet<>();
        for(int heater:heaters){
            set.add(heater);
        }
        int min=0;
        for(int house:houses){
            Integer floor=set.floor(house);
            Integer ceil=set.ceiling(house);
            min=Math.max(min,
                    Math.min(floor!=null?house-floor:Integer.MAX_VALUE,
                             ceil!=null?ceil-house:Integer.MAX_VALUE));
        }
        return min;
    }