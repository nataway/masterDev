/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package with_code_gen;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class Address extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Address\",\"namespace\":\"with_code_gen\",\"fields\":[{\"name\":\"Street\",\"type\":\"string\",\"default\":\"NONE\"},{\"name\":\"City\",\"type\":\"string\",\"default\":\"NONE\"},{\"name\":\"Country\",\"type\":\"string\",\"default\":\"NONE\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public java.lang.CharSequence Street;
  @Deprecated public java.lang.CharSequence City;
  @Deprecated public java.lang.CharSequence Country;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public Address() {}

  /**
   * All-args constructor.
   */
  public Address(java.lang.CharSequence Street, java.lang.CharSequence City, java.lang.CharSequence Country) {
    this.Street = Street;
    this.City = City;
    this.Country = Country;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return Street;
    case 1: return City;
    case 2: return Country;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: Street = (java.lang.CharSequence)value$; break;
    case 1: City = (java.lang.CharSequence)value$; break;
    case 2: Country = (java.lang.CharSequence)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'Street' field.
   */
  public java.lang.CharSequence getStreet() {
    return Street;
  }

  /**
   * Sets the value of the 'Street' field.
   * @param value the value to set.
   */
  public void setStreet(java.lang.CharSequence value) {
    this.Street = value;
  }

  /**
   * Gets the value of the 'City' field.
   */
  public java.lang.CharSequence getCity() {
    return City;
  }

  /**
   * Sets the value of the 'City' field.
   * @param value the value to set.
   */
  public void setCity(java.lang.CharSequence value) {
    this.City = value;
  }

  /**
   * Gets the value of the 'Country' field.
   */
  public java.lang.CharSequence getCountry() {
    return Country;
  }

  /**
   * Sets the value of the 'Country' field.
   * @param value the value to set.
   */
  public void setCountry(java.lang.CharSequence value) {
    this.Country = value;
  }

  /** Creates a new Address RecordBuilder */
  public static with_code_gen.Address.Builder newBuilder() {
    return new with_code_gen.Address.Builder();
  }
  
  /** Creates a new Address RecordBuilder by copying an existing Builder */
  public static with_code_gen.Address.Builder newBuilder(with_code_gen.Address.Builder other) {
    return new with_code_gen.Address.Builder(other);
  }
  
  /** Creates a new Address RecordBuilder by copying an existing Address instance */
  public static with_code_gen.Address.Builder newBuilder(with_code_gen.Address other) {
    return new with_code_gen.Address.Builder(other);
  }
  
  /**
   * RecordBuilder for Address instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Address>
    implements org.apache.avro.data.RecordBuilder<Address> {

    private java.lang.CharSequence Street;
    private java.lang.CharSequence City;
    private java.lang.CharSequence Country;

    /** Creates a new Builder */
    private Builder() {
      super(with_code_gen.Address.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(with_code_gen.Address.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.Street)) {
        this.Street = data().deepCopy(fields()[0].schema(), other.Street);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.City)) {
        this.City = data().deepCopy(fields()[1].schema(), other.City);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.Country)) {
        this.Country = data().deepCopy(fields()[2].schema(), other.Country);
        fieldSetFlags()[2] = true;
      }
    }
    
    /** Creates a Builder by copying an existing Address instance */
    private Builder(with_code_gen.Address other) {
            super(with_code_gen.Address.SCHEMA$);
      if (isValidValue(fields()[0], other.Street)) {
        this.Street = data().deepCopy(fields()[0].schema(), other.Street);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.City)) {
        this.City = data().deepCopy(fields()[1].schema(), other.City);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.Country)) {
        this.Country = data().deepCopy(fields()[2].schema(), other.Country);
        fieldSetFlags()[2] = true;
      }
    }

    /** Gets the value of the 'Street' field */
    public java.lang.CharSequence getStreet() {
      return Street;
    }
    
    /** Sets the value of the 'Street' field */
    public with_code_gen.Address.Builder setStreet(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.Street = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'Street' field has been set */
    public boolean hasStreet() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'Street' field */
    public with_code_gen.Address.Builder clearStreet() {
      Street = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'City' field */
    public java.lang.CharSequence getCity() {
      return City;
    }
    
    /** Sets the value of the 'City' field */
    public with_code_gen.Address.Builder setCity(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.City = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'City' field has been set */
    public boolean hasCity() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'City' field */
    public with_code_gen.Address.Builder clearCity() {
      City = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /** Gets the value of the 'Country' field */
    public java.lang.CharSequence getCountry() {
      return Country;
    }
    
    /** Sets the value of the 'Country' field */
    public with_code_gen.Address.Builder setCountry(java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.Country = value;
      fieldSetFlags()[2] = true;
      return this; 
    }
    
    /** Checks whether the 'Country' field has been set */
    public boolean hasCountry() {
      return fieldSetFlags()[2];
    }
    
    /** Clears the value of the 'Country' field */
    public with_code_gen.Address.Builder clearCountry() {
      Country = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    public Address build() {
      try {
        Address record = new Address();
        record.Street = fieldSetFlags()[0] ? this.Street : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.City = fieldSetFlags()[1] ? this.City : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.Country = fieldSetFlags()[2] ? this.Country : (java.lang.CharSequence) defaultValue(fields()[2]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}
