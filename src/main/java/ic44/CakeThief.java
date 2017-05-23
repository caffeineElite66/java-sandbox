
class CakeThief {

    public static void main(String[] args) {
        CakeType[] cakeTypes = new CakeType[]{
                new CakeType(7, 160),
                new CakeType(3, 90),
                new CakeType(2, 15),
        };

        int capacity = 11;

        System.out.println(maxDuffelBagValue(cakeTypes, capacity));


    }

    private static long maxDuffelBagValue(CakeType[] cakeTypes, int weightCapacity) {
        long[] maxValuesAtCapacities = new long[weightCapacity + 1];
        for (int currentCapacity = 0; currentCapacity <= weightCapacity; currentCapacity++) {
            long currentMaxValue = 0;
            for (CakeType cakeType : cakeTypes) {
                if (cakeType.weight == 0 && cakeType.value != 0) {
                    return -1;
                }

                if (cakeType.weight <= currentCapacity) {
                    int index = currentCapacity - cakeType.weight;
                    long maxValueUsingCake = cakeType.value + maxValuesAtCapacities[index];
                    currentMaxValue = Math.max(maxValueUsingCake, currentMaxValue);
                }
            }
            maxValuesAtCapacities[currentCapacity] = currentMaxValue;
        }
        return maxValuesAtCapacities[weightCapacity];
    }

    static class CakeType {
        int weight;
        int value;

        CakeType(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

}
