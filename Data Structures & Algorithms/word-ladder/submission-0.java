class Solution {
    class Pair {
        String str;
        int steps;
        public Pair(String str, int steps) {
            this.str = str;
            this.steps = steps;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for(String str:wordList) {
            set.add(str);
        }

        if(!set.contains(endWord)) return 0;

        Queue<Pair> que = new LinkedList<>();
        que.offer(new Pair(beginWord, 1));

        set.remove(beginWord);

        while(!que.isEmpty()) {
            Pair pair = que.poll();

            String currStr = pair.str;
            int steps = pair.steps;

            for(int i =0;i<currStr.length();i++) {
                char[] currArray = currStr.toCharArray();
                char currentChar = currArray[i];

                for(char ch = 'a'; ch <= 'z'; ch++) {
                    if(ch == currentChar) continue;

                    currArray[i] = ch;

                    String changedStr = new String(currArray);

                    if(changedStr.equals(endWord)) return steps+1;

                    if(set.contains(changedStr)){
                        que.offer(new Pair(changedStr, steps+1));
                        set.remove(changedStr);
                    }
                } 
                currArray[i] = currentChar;
            } 
        }
        return 0;
    }
}
