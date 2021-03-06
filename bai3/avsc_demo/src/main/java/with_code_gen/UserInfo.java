/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package with_code_gen;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class UserInfo extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"UserInfo\",\"namespace\":\"with_code_gen\",\"fields\":[{\"name\":\"FistName\",\"type\":\"string\",\"default\":\"NONE\"},{\"name\":\"LastName\",\"type\":\"string\",\"default\":\"NONE\"},{\"name\":\"Age\",\"type\":\"int\",\"default\":-1},{\"name\":\"Genger\",\"type\":{\"type\":\"enum\",\"name\":\"Gender\",\"symbols\":[\"Male\",\"female\"]}},{\"name\":\"Phone\",\"type\":\"string\",\"default\":\"NONE\"},{\"name\":\"ListAddress\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"Address\",\"fields\":[{\"name\":\"Street\",\"type\":\"string\",\"default\":\"NONE\"},{\"name\":\"City\",\"type\":\"string\",\"default\":\"NONE\"},{\"name\":\"Country\",\"type\":\"string\",\"default\":\"NONE\"}]}}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public java.lang.CharSequence FistName;
  @Deprecated public java.lang.CharSequence LastName;
  @Deprecated public int Age;
  @Deprecated public with_code_gen.Gender Genger;
  @Deprecated public java.lang.CharSequence Phone;
  @Deprecated public java.util.List<with_code_gen.Address> ListAddress;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public UserInfo() {}

  /**
   * All-args constructor.
   */
  public UserInfo(java.lang.CharSequence FistName, java.lang.CharSequence LastName, java.lang.Integer Age, with_code_gen.Gender Genger, java.lang.CharSequence Phone, java.util.List<with_code_gen.Address> ListAddress) {
    this.FistName = FistName;
    this.LastName = LastName;
    this.Age = Age;
    this.Genger = Genger;
    this.Phone = Phone;
    this.ListAddress = ListAddress;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return FistName;
    case 1: return LastName;
    case 2: return Age;
    case 3: return Genger;
    case 4: return Phone;
    case 5: return ListAddress;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: FistName = (java.lang.CharSequence)value$; break;
    case 1: LastName = (java.lang.CharSequence)value$; break;
    case 2: Age = (java.lang.Integer)value$; break;
    case 3: Genger = (with_code_gen.Gender)value$; break;
    case 4: Phone = (java.lang.CharSequence)value$; break;
    case 5: ListAddress = (java.util.List<with_code_gen.Address>)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'FistName' field.
   */
  public java.lang.CharSequence getFistName() {
    return FistName;
  }

  /**
   * Sets the value of the 'FistName' field.
   * @param value the value to set.
   */
  public void setFistName(java.lang.CharSequence value) {
    this.FistName = value;
  }

  /**
   * Gets the value of the 'LastName' field.
   */
  public java.lang.CharSequence getLastName() {
    return LastName;
  }

  /**
   * Sets the value of the 'LastName' field.
   * @param value the value to set.
   */
  public void setLastName(java.lang.CharSequence value) {
    this.LastName = value;
  }

  /**
   * Gets the value of the 'Age' field.
   */
  public java.lang.Integer getAge() {
    return Age;
  }

  /**
   * Sets the value of the 'Age' field.
   * @param value the value to set.
   */
  public void setAge(java.lang.Integer value) {
    this.Age = value;
  }

  /**
   * Gets the value of the 'Genger' field.
   */
  public with_code_gen.Gender getGenger() {
    return Genger;
  }

  /**
   * Sets the value of the 'Genger' field.
   * @param value the value to set.
   */
  public void setGenger(with_code_gen.Gender value) {
    this.Genger = value;
  }

  /**
   * Gets the value of the 'Phone' field.
   */
  public java.lang.CharSequence getPhone() {
    return Phone;
  }

  /**
   * Sets the value of the 'Phone' field.
   * @param value the value to set.
   */
  public void setPhone(java.lang.CharSequence value) {
    this.Phone = value;
  }

  /**
   * Gets the value of the 'ListAddress' field.
   */
  public java.util.List<with_code_gen.Address> getListAddress() {
    return ListAddress;
  }

  /**
   * Sets the value of the 'ListAddress' field.
   * @param value the value to set.
   */
  public void setListAddress(java.util.List<with_code_gen.Address> value) {
    this.ListAddress = value;
  }

  /** Creates a new UserInfo RecordBuilder */
  public static with_code_gen.UserInfo.Builder newBuilder() {
    return new with_code_gen.UserInfo.Builder();
  }
  
  /** Creates a new UserInfo RecordBuilder by copying an existing Builder */
  public static with_code_gen.UserInfo.Builder newBuilder(with_code_gen.UserInfo.Builder other) {
    return new with_code_gen.UserInfo.Builder(other);
  }
  
  /** Creates a new UserInfo RecordBuilder by copying an existing UserInfo instance */
  public static with_code_gen.UserInfo.Builder newBuilder(with_code_gen.UserInfo other) {
    return new with_code_gen.UserInfo.Builder(other);
  }
  
  /**
   * RecordBuilder for UserInfo instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<UserInfo>
    implements org.apache.avro.data.RecordBuilder<UserInfo> {

    private java.lang.CharSequence FistName;
    private java.lang.CharSequence LastName;
    private int Age;
    private with_code_gen.Gender Genger;
    private java.lang.CharSequence Phone;
    private java.util.List<with_code_gen.Address> ListAddress;

    /** Creates a new Builder */
    private Builder() {
      super(with_code_gen.UserInfo.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(with_code_gen.UserInfo.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.FistName)) {
        this.FistName = data().deepCopy(fields()[0].schema(), other.FistName);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.LastName)) {
        this.LastName = data().deepCopy(fields()[1].schema(), other.LastName);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.Age)) {
        this.Age = data().deepCopy(fields()[2].schema(), other.Age);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.Genger)) {
        this.Genger = data().deepCopy(fields()[3].schema(), other.Genger);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.Phone)) {
        this.Phone = data().deepCopy(fields()[4].schema(), other.Phone);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.ListAddress)) {
        this.ListAddress = data().deepCopy(fields()[5].schema(), other.ListAddress);
        fieldSetFlags()[5] = true;
      }
    }
    
    /** Creates a Builder by copying an existing UserInfo instance */
    private Builder(with_code_gen.UserInfo other) {
            super(with_code_gen.UserInfo.SCHEMA$);
      if (isValidValue(fields()[0], other.FistName)) {
        this.FistName = data().deepCopy(fields()[0].schema(), other.FistName);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.LastName)) {
        this.LastName = data().deepCopy(fields()[1].schema(), other.LastName);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.Age)) {
        this.Age = data().deepCopy(fields()[2].schema(), other.Age);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.Genger)) {
        this.Genger = data().deepCopy(fields()[3].schema(), other.Genger);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.Phone)) {
        this.Phone = data().deepCopy(fields()[4].schema(), other.Phone);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.ListAddress)) {
        this.ListAddress = data().deepCopy(fields()[5].schema(), other.ListAddress);
        fieldSetFlags()[5] = true;
      }
    }

    /** Gets the value of the 'FistName' field */
    public java.lang.CharSequence getFistName() {
      return FistName;
    }
    
    /** Sets the value of the 'FistName' field */
    public with_code_gen.UserInfo.Builder setFistName(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.FistName = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'FistName' field has been set */
    public boolean hasFistName() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'FistName' field */
    public with_code_gen.UserInfo.Builder clearFistName() {
      FistName = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'LastName' field */
    public java.lang.CharSequence getLastName() {
      return LastName;
    }
    
    /** Sets the value of the 'LastName' field */
    public with_code_gen.UserInfo.Builder setLastName(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.LastName = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'LastName' field has been set */
    public boolean hasLastName() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'LastName' field */
    public with_code_gen.UserInfo.Builder clearLastName() {
      LastName = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /** Gets the value of the 'Age' field */
    public java.lang.Integer getAge() {
      return Age;
    }
    
    /** Sets the value of the 'Age' field */
    public with_code_gen.UserInfo.Builder setAge(int value) {
      validate(fields()[2], value);
      this.Age = value;
      fieldSetFlags()[2] = true;
      return this; 
    }
    
    /** Checks whether the 'Age' field has been set */
    public boolean hasAge() {
      return fieldSetFlags()[2];
    }
    
    /** Clears the value of the 'Age' field */
    public with_code_gen.UserInfo.Builder clearAge() {
      fieldSetFlags()[2] = false;
      return this;
    }

    /** Gets the value of the 'Genger' field */
    public with_code_gen.Gender getGenger() {
      return Genger;
    }
    
    /** Sets the value of the 'Genger' field */
    public with_code_gen.UserInfo.Builder setGenger(with_code_gen.Gender value) {
      validate(fields()[3], value);
      this.Genger = value;
      fieldSetFlags()[3] = true;
      return this; 
    }
    
    /** Checks whether the 'Genger' field has been set */
    public boolean hasGenger() {
      return fieldSetFlags()[3];
    }
    
    /** Clears the value of the 'Genger' field */
    public with_code_gen.UserInfo.Builder clearGenger() {
      Genger = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /** Gets the value of the 'Phone' field */
    public java.lang.CharSequence getPhone() {
      return Phone;
    }
    
    /** Sets the value of the 'Phone' field */
    public with_code_gen.UserInfo.Builder setPhone(java.lang.CharSequence value) {
      validate(fields()[4], value);
      this.Phone = value;
      fieldSetFlags()[4] = true;
      return this; 
    }
    
    /** Checks whether the 'Phone' field has been set */
    public boolean hasPhone() {
      return fieldSetFlags()[4];
    }
    
    /** Clears the value of the 'Phone' field */
    public with_code_gen.UserInfo.Builder clearPhone() {
      Phone = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    /** Gets the value of the 'ListAddress' field */
    public java.util.List<with_code_gen.Address> getListAddress() {
      return ListAddress;
    }
    
    /** Sets the value of the 'ListAddress' field */
    public with_code_gen.UserInfo.Builder setListAddress(java.util.List<with_code_gen.Address> value) {
      validate(fields()[5], value);
      this.ListAddress = value;
      fieldSetFlags()[5] = true;
      return this; 
    }
    
    /** Checks whether the 'ListAddress' field has been set */
    public boolean hasListAddress() {
      return fieldSetFlags()[5];
    }
    
    /** Clears the value of the 'ListAddress' field */
    public with_code_gen.UserInfo.Builder clearListAddress() {
      ListAddress = null;
      fieldSetFlags()[5] = false;
      return this;
    }

    @Override
    public UserInfo build() {
      try {
        UserInfo record = new UserInfo();
        record.FistName = fieldSetFlags()[0] ? this.FistName : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.LastName = fieldSetFlags()[1] ? this.LastName : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.Age = fieldSetFlags()[2] ? this.Age : (java.lang.Integer) defaultValue(fields()[2]);
        record.Genger = fieldSetFlags()[3] ? this.Genger : (with_code_gen.Gender) defaultValue(fields()[3]);
        record.Phone = fieldSetFlags()[4] ? this.Phone : (java.lang.CharSequence) defaultValue(fields()[4]);
        record.ListAddress = fieldSetFlags()[5] ? this.ListAddress : (java.util.List<with_code_gen.Address>) defaultValue(fields()[5]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}
