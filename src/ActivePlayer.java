public enum ActivePlayer {
    BLACK,
    WHITE {
        @Override
        public ActivePlayer next(){
            return values()[0];
        }
    };

    public ActivePlayer next(){
        return values()[ordinal() + 1];
    }
}
