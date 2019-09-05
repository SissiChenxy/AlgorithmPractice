package DFS.Combinations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CombinationsForPhonePad {
        public String[] combinations(int number) {
            // Write your solution here
            if(number == 0){
                return new String[0];
            }

            String[] phonePad = {"", "","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

            List<String> options = new ArrayList<>();
            while(number > 0){
                int rem = number % 10;
                String ele = phonePad[rem];
                if(!ele.isEmpty()){
                    options.add(ele);
                }
                number /= 10;
            }

            reverse(options);

            List<String> result = new ArrayList<String>();
            char[] current = new char[options.size()];

            combinations(result, options, current, 0);
            String[] array = new String[result.size()];

            for(int j = 0; j < result.size(); j++){
                array[j] = result.get(j);
            }

            return array;
        }

        private void combinations(List<String> result, List<String> options, char[] current, int index){
            if(index == options.size()){
                result.add(new String(current));
                return;
            }

            char[] elements = options.get(index).toCharArray();
            for(int i = 0; i < elements.length; i++){
                current[index] = elements[i];
                combinations(result, options, current, index + 1);
            }
        }

        private void reverse(List<String> options){
            int i = 0;
            int j = options.size() - 1;
            while(i < j){
                String temp = options.get(i);
                options.set(i, options.get(j));
                options.set(j, temp);
                i++;
                j--;
            }
        }

}
