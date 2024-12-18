public class GetWordCount {

    public static int countWords(String s) {
            String words[] = s.trim().split("\\s+");

            for (String word : words) {
                System.out.println(word);
            }

            System.out.print("Words count is ");
            return words.length;
        }


        public static void main(String[] args) {
            int count = countWords("Heloo.. I am working here" );
            System.out.println(count);
        }
    }
