class User {
    public int rank = -8;
    public int progress = 0;

    public User() {
    }

    public void incProgress(int rank) {
        if (rank < -8 || rank > 8 || rank == 0) {
            throw new IllegalArgumentException();
        }


        if (this.rank == rank) {
            this.progress += 3;
        }


        if (this.rank - 1 == rank) {
            this.progress += 1;
        }

        if (rank ==-1) {

            this.progress = 21;
        }
        if (rank ==3) {

            this.progress = 61;
        }
        if (this.rank < rank && rank <0 && rank!= -1) {
            int d = rank - this.rank;
            this.progress += (10 * d * d);
        }
        if (this.rank < rank && rank >0 && rank!=3) {
            int d = rank - this.rank -1;
            this.progress += (10 * d * d);
        }
        if (rank == 8)
            this.rank = 6;

        while (this.progress >= 100 && this.rank < 8) {
            this.rank++;
            this.progress -= 100;
            if (this.rank == 0){
                ++this.rank;
            }
            if (this.rank == 8) {
                this.progress = 0;
            }
        }
    }


    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }




}



