import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class SetOperations {

    private final Set<Integer> set1;
    private final Set<Integer> set2;

    public SetOperations(Set<Integer> set1, Set<Integer> set2) {

        this.set1 = set1;
        this.set2 = set2;
    }

    public void union() {
        SortedSet<Integer> union = new TreeSet<>(set1);
        union.addAll(set2);
        printSet(union, "union of sets is:{ ");
    }


    public void intersection() {
        if (set1.size() >= set2.size()) {
            //collecting the elements from set 1 which are also avaialble in set 2; :: is a method reference syntax in Java.
            Set<Integer> resultOfintersection = set1.stream().filter(set2::contains).collect(Collectors.toSet());
            printSet(new TreeSet<>(resultOfintersection), "Intersection of Set1 with Set2 is: {");
        } else { // set2 is larger
            Set<Integer> resultOfintersection = set2.stream().filter(set1::contains).collect(Collectors.toSet());
            printSet(new TreeSet<>(resultOfintersection), "Intersection of Set2 with Set1 is: {");
        }
    }

    public void subSet() {
        if (set1.size() >= set2.size()) {
            doCheckSubset(set2, set1);
        } else { // set2 is larger.
            doCheckSubset(set1, set2);
        }
    }

    private void doCheckSubset(Set<Integer> smallSet, Set<Integer> bigSet) {
        Set<Integer> elementsOfSet2InSet1 = smallSet.stream().filter(bigSet::contains).collect(Collectors.toSet());
        if (elementsOfSet2InSet1.size() == smallSet.size()) {
            printSet(new TreeSet<>(smallSet), "Following is the Subset Detected {");
        } else {
            System.out.println("Provided Sets are not subsets of each other");
            printSet(new TreeSet<>(smallSet), "{");
            printSet(new TreeSet<>(bigSet), "{");
        }
    }

    private void printSet(SortedSet<Integer> set, String message) {
        System.out.print(message);
        int i = 0;
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            if (i == set.size() - 1) {
                System.out.print(iterator.next());
            } else {
                System.out.print(iterator.next() + ",");
            }
            i += 1;
        }
        System.out.print("} \n");
    }
}
