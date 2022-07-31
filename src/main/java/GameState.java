public enum GameState{
    PLAYER_CHOOSE_FIGURE,
    PLAYER_MOVE_FIGURE{
        @Override
        public GameState next() throws GameEndException
        {
            return values()[0];
        }
    },
    CHECK,
    CHECK_MATE{
      @Override
      public GameState next() throws GameEndException
      {
          throw new GameEndException();
      }
    };

    public GameState next() throws GameEndException
    {
        return values()[ordinal() + 1];
    }
}
