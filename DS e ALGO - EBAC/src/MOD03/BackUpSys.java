package MOD03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BackUpSys {

    public interface Batch{
        int[] getFileSize();
        int getTapeSize();

    }

    private static class NewBatch implements Batch{


        @Override
        public int[] getFileSize() {
            return new int[]{70, 10, 20,40,50,60,50,100,100};

        }

        @Override
        public int getTapeSize() {
            return 100;
        }
    }

    private class Tape{
        private int stored;
        private int numberFile;

        public Tape(int stored){
            this.stored = stored;
            this.numberFile =  1;
        }

        public int getStored() {
            return stored;
        }

        public void addStorage(int storage){
            this.stored += storage;

        }
        public void addFile(){
            this.numberFile++;
        }

        public int getNumberFile() {
            return numberFile;
        }
    }

    public int getMinimumTapeCount(final Batch batch){
        int[] sizes = batch.getFileSize();
        Arrays.sort(sizes);

        int tapes = 0;
        List<Tape> list = new ArrayList<>();
        for (int i = sizes.length - 1; i > -1 ; i--) {
            boolean stored = false;

            for( Tape tape : list){
                if (((tape.getStored() + sizes[i]) <= batch.getTapeSize()) && (tape.getNumberFile() < 2)){
                    tape.addStorage(sizes[i]);
                    tape.addFile();
                    stored = true;
                    break;
                }
            }

            if (!stored){
                tapes++;
                list.add(new Tape(sizes[i]));
            }

        }



        return tapes;
    }

    public static void main(String[] args) {
        BackUpSys backUpSys =  new BackUpSys();
        Batch batch = new NewBatch();

        System.out.println(backUpSys.getMinimumTapeCount(batch));
    }
}
