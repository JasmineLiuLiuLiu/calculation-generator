package calculate.metadata;

public enum DataType {
  INT(0), FLOAT(1);
  private final int i;

  DataType(int i) {
    this.i = i;
  }

  public static DataType getDataType(int i) {
    int j = i % DataType.values().length;
    return DataType.values()[j];
  }
}
