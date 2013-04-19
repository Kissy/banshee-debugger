// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Proto/Debug/ObjectProperty.proto

package fr.kissy.banshee.proto;

public final class ObjectPropertyDto {
  private ObjectPropertyDto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  public interface ObjectPropertyProtoOrBuilder
      extends com.google.protobuf.MessageOrBuilder {
    
    // optional string category = 1 [default = "default"];
    boolean hasCategory();
    String getCategory();
    
    // repeated .PropertyProto properties = 2;
    java.util.List<fr.kissy.hellion.proto.common.PropertyDto.PropertyProto> 
        getPropertiesList();
    fr.kissy.hellion.proto.common.PropertyDto.PropertyProto getProperties(int index);
    int getPropertiesCount();
    java.util.List<? extends fr.kissy.hellion.proto.common.PropertyDto.PropertyProtoOrBuilder> 
        getPropertiesOrBuilderList();
    fr.kissy.hellion.proto.common.PropertyDto.PropertyProtoOrBuilder getPropertiesOrBuilder(
        int index);
  }
  public static final class ObjectPropertyProto extends
      com.google.protobuf.GeneratedMessage
      implements ObjectPropertyProtoOrBuilder {
    // Use ObjectPropertyProto.newBuilder() to construct.
    private ObjectPropertyProto(Builder builder) {
      super(builder);
    }
    private ObjectPropertyProto(boolean noInit) {}
    
    private static final ObjectPropertyProto defaultInstance;
    public static ObjectPropertyProto getDefaultInstance() {
      return defaultInstance;
    }
    
    public ObjectPropertyProto getDefaultInstanceForType() {
      return defaultInstance;
    }
    
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return fr.kissy.banshee.proto.ObjectPropertyDto.internal_static_ObjectPropertyProto_descriptor;
    }
    
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return fr.kissy.banshee.proto.ObjectPropertyDto.internal_static_ObjectPropertyProto_fieldAccessorTable;
    }
    
    private int bitField0_;
    // optional string category = 1 [default = "default"];
    public static final int CATEGORY_FIELD_NUMBER = 1;
    private java.lang.Object category_;
    public boolean hasCategory() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    public String getCategory() {
      java.lang.Object ref = category_;
      if (ref instanceof String) {
        return (String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        if (com.google.protobuf.Internal.isValidUtf8(bs)) {
          category_ = s;
        }
        return s;
      }
    }
    private com.google.protobuf.ByteString getCategoryBytes() {
      java.lang.Object ref = category_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8((String) ref);
        category_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    
    // repeated .PropertyProto properties = 2;
    public static final int PROPERTIES_FIELD_NUMBER = 2;
    private java.util.List<fr.kissy.hellion.proto.common.PropertyDto.PropertyProto> properties_;
    public java.util.List<fr.kissy.hellion.proto.common.PropertyDto.PropertyProto> getPropertiesList() {
      return properties_;
    }
    public java.util.List<? extends fr.kissy.hellion.proto.common.PropertyDto.PropertyProtoOrBuilder> 
        getPropertiesOrBuilderList() {
      return properties_;
    }
    public int getPropertiesCount() {
      return properties_.size();
    }
    public fr.kissy.hellion.proto.common.PropertyDto.PropertyProto getProperties(int index) {
      return properties_.get(index);
    }
    public fr.kissy.hellion.proto.common.PropertyDto.PropertyProtoOrBuilder getPropertiesOrBuilder(
        int index) {
      return properties_.get(index);
    }
    
    private void initFields() {
      category_ = "default";
      properties_ = java.util.Collections.emptyList();
    }
    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized != -1) return isInitialized == 1;
      
      for (int i = 0; i < getPropertiesCount(); i++) {
        if (!getProperties(i).isInitialized()) {
          memoizedIsInitialized = 0;
          return false;
        }
      }
      memoizedIsInitialized = 1;
      return true;
    }
    
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        output.writeBytes(1, getCategoryBytes());
      }
      for (int i = 0; i < properties_.size(); i++) {
        output.writeMessage(2, properties_.get(i));
      }
      getUnknownFields().writeTo(output);
    }
    
    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;
    
      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(1, getCategoryBytes());
      }
      for (int i = 0; i < properties_.size(); i++) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(2, properties_.get(i));
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }
    
    private static final long serialVersionUID = 0L;
    @java.lang.Override
    protected java.lang.Object writeReplace()
        throws java.io.ObjectStreamException {
      return super.writeReplace();
    }
    
    public static fr.kissy.banshee.proto.ObjectPropertyDto.ObjectPropertyProto parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data).buildParsed();
    }
    public static fr.kissy.banshee.proto.ObjectPropertyDto.ObjectPropertyProto parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data, extensionRegistry)
               .buildParsed();
    }
    public static fr.kissy.banshee.proto.ObjectPropertyDto.ObjectPropertyProto parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data).buildParsed();
    }
    public static fr.kissy.banshee.proto.ObjectPropertyDto.ObjectPropertyProto parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data, extensionRegistry)
               .buildParsed();
    }
    public static fr.kissy.banshee.proto.ObjectPropertyDto.ObjectPropertyProto parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input).buildParsed();
    }
    public static fr.kissy.banshee.proto.ObjectPropertyDto.ObjectPropertyProto parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input, extensionRegistry)
               .buildParsed();
    }
    public static fr.kissy.banshee.proto.ObjectPropertyDto.ObjectPropertyProto parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      Builder builder = newBuilder();
      if (builder.mergeDelimitedFrom(input)) {
        return builder.buildParsed();
      } else {
        return null;
      }
    }
    public static fr.kissy.banshee.proto.ObjectPropertyDto.ObjectPropertyProto parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      Builder builder = newBuilder();
      if (builder.mergeDelimitedFrom(input, extensionRegistry)) {
        return builder.buildParsed();
      } else {
        return null;
      }
    }
    public static fr.kissy.banshee.proto.ObjectPropertyDto.ObjectPropertyProto parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input).buildParsed();
    }
    public static fr.kissy.banshee.proto.ObjectPropertyDto.ObjectPropertyProto parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input, extensionRegistry)
               .buildParsed();
    }
    
    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(fr.kissy.banshee.proto.ObjectPropertyDto.ObjectPropertyProto prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }
    
    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder>
       implements fr.kissy.banshee.proto.ObjectPropertyDto.ObjectPropertyProtoOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return fr.kissy.banshee.proto.ObjectPropertyDto.internal_static_ObjectPropertyProto_descriptor;
      }
      
      protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return fr.kissy.banshee.proto.ObjectPropertyDto.internal_static_ObjectPropertyProto_fieldAccessorTable;
      }
      
      // Construct using fr.kissy.banshee.proto.ObjectPropertyDto.ObjectPropertyProto.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }
      
      private Builder(BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
          getPropertiesFieldBuilder();
        }
      }
      private static Builder create() {
        return new Builder();
      }
      
      public Builder clear() {
        super.clear();
        category_ = "default";
        bitField0_ = (bitField0_ & ~0x00000001);
        if (propertiesBuilder_ == null) {
          properties_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000002);
        } else {
          propertiesBuilder_.clear();
        }
        return this;
      }
      
      public Builder clone() {
        return create().mergeFrom(buildPartial());
      }
      
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return fr.kissy.banshee.proto.ObjectPropertyDto.ObjectPropertyProto.getDescriptor();
      }
      
      public fr.kissy.banshee.proto.ObjectPropertyDto.ObjectPropertyProto getDefaultInstanceForType() {
        return fr.kissy.banshee.proto.ObjectPropertyDto.ObjectPropertyProto.getDefaultInstance();
      }
      
      public fr.kissy.banshee.proto.ObjectPropertyDto.ObjectPropertyProto build() {
        fr.kissy.banshee.proto.ObjectPropertyDto.ObjectPropertyProto result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }
      
      private fr.kissy.banshee.proto.ObjectPropertyDto.ObjectPropertyProto buildParsed()
          throws com.google.protobuf.InvalidProtocolBufferException {
        fr.kissy.banshee.proto.ObjectPropertyDto.ObjectPropertyProto result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(
            result).asInvalidProtocolBufferException();
        }
        return result;
      }
      
      public fr.kissy.banshee.proto.ObjectPropertyDto.ObjectPropertyProto buildPartial() {
        fr.kissy.banshee.proto.ObjectPropertyDto.ObjectPropertyProto result = new fr.kissy.banshee.proto.ObjectPropertyDto.ObjectPropertyProto(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.category_ = category_;
        if (propertiesBuilder_ == null) {
          if (((bitField0_ & 0x00000002) == 0x00000002)) {
            properties_ = java.util.Collections.unmodifiableList(properties_);
            bitField0_ = (bitField0_ & ~0x00000002);
          }
          result.properties_ = properties_;
        } else {
          result.properties_ = propertiesBuilder_.build();
        }
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }
      
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof fr.kissy.banshee.proto.ObjectPropertyDto.ObjectPropertyProto) {
          return mergeFrom((fr.kissy.banshee.proto.ObjectPropertyDto.ObjectPropertyProto)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }
      
      public Builder mergeFrom(fr.kissy.banshee.proto.ObjectPropertyDto.ObjectPropertyProto other) {
        if (other == fr.kissy.banshee.proto.ObjectPropertyDto.ObjectPropertyProto.getDefaultInstance()) return this;
        if (other.hasCategory()) {
          setCategory(other.getCategory());
        }
        if (propertiesBuilder_ == null) {
          if (!other.properties_.isEmpty()) {
            if (properties_.isEmpty()) {
              properties_ = other.properties_;
              bitField0_ = (bitField0_ & ~0x00000002);
            } else {
              ensurePropertiesIsMutable();
              properties_.addAll(other.properties_);
            }
            onChanged();
          }
        } else {
          if (!other.properties_.isEmpty()) {
            if (propertiesBuilder_.isEmpty()) {
              propertiesBuilder_.dispose();
              propertiesBuilder_ = null;
              properties_ = other.properties_;
              bitField0_ = (bitField0_ & ~0x00000002);
              propertiesBuilder_ = 
                com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders ?
                   getPropertiesFieldBuilder() : null;
            } else {
              propertiesBuilder_.addAllMessages(other.properties_);
            }
          }
        }
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }
      
      public final boolean isInitialized() {
        for (int i = 0; i < getPropertiesCount(); i++) {
          if (!getProperties(i).isInitialized()) {
            
            return false;
          }
        }
        return true;
      }
      
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder(
            this.getUnknownFields());
        while (true) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              this.setUnknownFields(unknownFields.build());
              onChanged();
              return this;
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                this.setUnknownFields(unknownFields.build());
                onChanged();
                return this;
              }
              break;
            }
            case 10: {
              bitField0_ |= 0x00000001;
              category_ = input.readBytes();
              break;
            }
            case 18: {
              fr.kissy.hellion.proto.common.PropertyDto.PropertyProto.Builder subBuilder = fr.kissy.hellion.proto.common.PropertyDto.PropertyProto.newBuilder();
              input.readMessage(subBuilder, extensionRegistry);
              addProperties(subBuilder.buildPartial());
              break;
            }
          }
        }
      }
      
      private int bitField0_;
      
      // optional string category = 1 [default = "default"];
      private java.lang.Object category_ = "default";
      public boolean hasCategory() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      public String getCategory() {
        java.lang.Object ref = category_;
        if (!(ref instanceof String)) {
          String s = ((com.google.protobuf.ByteString) ref).toStringUtf8();
          category_ = s;
          return s;
        } else {
          return (String) ref;
        }
      }
      public Builder setCategory(String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
        category_ = value;
        onChanged();
        return this;
      }
      public Builder clearCategory() {
        bitField0_ = (bitField0_ & ~0x00000001);
        category_ = getDefaultInstance().getCategory();
        onChanged();
        return this;
      }
      void setCategory(com.google.protobuf.ByteString value) {
        bitField0_ |= 0x00000001;
        category_ = value;
        onChanged();
      }
      
      // repeated .PropertyProto properties = 2;
      private java.util.List<fr.kissy.hellion.proto.common.PropertyDto.PropertyProto> properties_ =
        java.util.Collections.emptyList();
      private void ensurePropertiesIsMutable() {
        if (!((bitField0_ & 0x00000002) == 0x00000002)) {
          properties_ = new java.util.ArrayList<fr.kissy.hellion.proto.common.PropertyDto.PropertyProto>(properties_);
          bitField0_ |= 0x00000002;
         }
      }
      
      private com.google.protobuf.RepeatedFieldBuilder<
          fr.kissy.hellion.proto.common.PropertyDto.PropertyProto, fr.kissy.hellion.proto.common.PropertyDto.PropertyProto.Builder, fr.kissy.hellion.proto.common.PropertyDto.PropertyProtoOrBuilder> propertiesBuilder_;
      
      public java.util.List<fr.kissy.hellion.proto.common.PropertyDto.PropertyProto> getPropertiesList() {
        if (propertiesBuilder_ == null) {
          return java.util.Collections.unmodifiableList(properties_);
        } else {
          return propertiesBuilder_.getMessageList();
        }
      }
      public int getPropertiesCount() {
        if (propertiesBuilder_ == null) {
          return properties_.size();
        } else {
          return propertiesBuilder_.getCount();
        }
      }
      public fr.kissy.hellion.proto.common.PropertyDto.PropertyProto getProperties(int index) {
        if (propertiesBuilder_ == null) {
          return properties_.get(index);
        } else {
          return propertiesBuilder_.getMessage(index);
        }
      }
      public Builder setProperties(
          int index, fr.kissy.hellion.proto.common.PropertyDto.PropertyProto value) {
        if (propertiesBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensurePropertiesIsMutable();
          properties_.set(index, value);
          onChanged();
        } else {
          propertiesBuilder_.setMessage(index, value);
        }
        return this;
      }
      public Builder setProperties(
          int index, fr.kissy.hellion.proto.common.PropertyDto.PropertyProto.Builder builderForValue) {
        if (propertiesBuilder_ == null) {
          ensurePropertiesIsMutable();
          properties_.set(index, builderForValue.build());
          onChanged();
        } else {
          propertiesBuilder_.setMessage(index, builderForValue.build());
        }
        return this;
      }
      public Builder addProperties(fr.kissy.hellion.proto.common.PropertyDto.PropertyProto value) {
        if (propertiesBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensurePropertiesIsMutable();
          properties_.add(value);
          onChanged();
        } else {
          propertiesBuilder_.addMessage(value);
        }
        return this;
      }
      public Builder addProperties(
          int index, fr.kissy.hellion.proto.common.PropertyDto.PropertyProto value) {
        if (propertiesBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensurePropertiesIsMutable();
          properties_.add(index, value);
          onChanged();
        } else {
          propertiesBuilder_.addMessage(index, value);
        }
        return this;
      }
      public Builder addProperties(
          fr.kissy.hellion.proto.common.PropertyDto.PropertyProto.Builder builderForValue) {
        if (propertiesBuilder_ == null) {
          ensurePropertiesIsMutable();
          properties_.add(builderForValue.build());
          onChanged();
        } else {
          propertiesBuilder_.addMessage(builderForValue.build());
        }
        return this;
      }
      public Builder addProperties(
          int index, fr.kissy.hellion.proto.common.PropertyDto.PropertyProto.Builder builderForValue) {
        if (propertiesBuilder_ == null) {
          ensurePropertiesIsMutable();
          properties_.add(index, builderForValue.build());
          onChanged();
        } else {
          propertiesBuilder_.addMessage(index, builderForValue.build());
        }
        return this;
      }
      public Builder addAllProperties(
          java.lang.Iterable<? extends fr.kissy.hellion.proto.common.PropertyDto.PropertyProto> values) {
        if (propertiesBuilder_ == null) {
          ensurePropertiesIsMutable();
          super.addAll(values, properties_);
          onChanged();
        } else {
          propertiesBuilder_.addAllMessages(values);
        }
        return this;
      }
      public Builder clearProperties() {
        if (propertiesBuilder_ == null) {
          properties_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000002);
          onChanged();
        } else {
          propertiesBuilder_.clear();
        }
        return this;
      }
      public Builder removeProperties(int index) {
        if (propertiesBuilder_ == null) {
          ensurePropertiesIsMutable();
          properties_.remove(index);
          onChanged();
        } else {
          propertiesBuilder_.remove(index);
        }
        return this;
      }
      public fr.kissy.hellion.proto.common.PropertyDto.PropertyProto.Builder getPropertiesBuilder(
          int index) {
        return getPropertiesFieldBuilder().getBuilder(index);
      }
      public fr.kissy.hellion.proto.common.PropertyDto.PropertyProtoOrBuilder getPropertiesOrBuilder(
          int index) {
        if (propertiesBuilder_ == null) {
          return properties_.get(index);  } else {
          return propertiesBuilder_.getMessageOrBuilder(index);
        }
      }
      public java.util.List<? extends fr.kissy.hellion.proto.common.PropertyDto.PropertyProtoOrBuilder> 
           getPropertiesOrBuilderList() {
        if (propertiesBuilder_ != null) {
          return propertiesBuilder_.getMessageOrBuilderList();
        } else {
          return java.util.Collections.unmodifiableList(properties_);
        }
      }
      public fr.kissy.hellion.proto.common.PropertyDto.PropertyProto.Builder addPropertiesBuilder() {
        return getPropertiesFieldBuilder().addBuilder(
            fr.kissy.hellion.proto.common.PropertyDto.PropertyProto.getDefaultInstance());
      }
      public fr.kissy.hellion.proto.common.PropertyDto.PropertyProto.Builder addPropertiesBuilder(
          int index) {
        return getPropertiesFieldBuilder().addBuilder(
            index, fr.kissy.hellion.proto.common.PropertyDto.PropertyProto.getDefaultInstance());
      }
      public java.util.List<fr.kissy.hellion.proto.common.PropertyDto.PropertyProto.Builder> 
           getPropertiesBuilderList() {
        return getPropertiesFieldBuilder().getBuilderList();
      }
      private com.google.protobuf.RepeatedFieldBuilder<
          fr.kissy.hellion.proto.common.PropertyDto.PropertyProto, fr.kissy.hellion.proto.common.PropertyDto.PropertyProto.Builder, fr.kissy.hellion.proto.common.PropertyDto.PropertyProtoOrBuilder> 
          getPropertiesFieldBuilder() {
        if (propertiesBuilder_ == null) {
          propertiesBuilder_ = new com.google.protobuf.RepeatedFieldBuilder<
              fr.kissy.hellion.proto.common.PropertyDto.PropertyProto, fr.kissy.hellion.proto.common.PropertyDto.PropertyProto.Builder, fr.kissy.hellion.proto.common.PropertyDto.PropertyProtoOrBuilder>(
                  properties_,
                  ((bitField0_ & 0x00000002) == 0x00000002),
                  getParentForChildren(),
                  isClean());
          properties_ = null;
        }
        return propertiesBuilder_;
      }
      
      // @@protoc_insertion_point(builder_scope:ObjectPropertyProto)
    }
    
    static {
      defaultInstance = new ObjectPropertyProto(true);
      defaultInstance.initFields();
    }
    
    // @@protoc_insertion_point(class_scope:ObjectPropertyProto)
  }
  
  private static com.google.protobuf.Descriptors.Descriptor
    internal_static_ObjectPropertyProto_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_ObjectPropertyProto_fieldAccessorTable;
  
  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n Proto/Debug/ObjectProperty.proto\032\033Prot" +
      "o/Common/Property.proto\"T\n\023ObjectPropert" +
      "yProto\022\031\n\010category\030\001 \001(\t:\007default\022\"\n\npro" +
      "perties\030\002 \003(\0132\016.PropertyProtoB.\n\026fr.kiss" +
      "y.banshee.protoB\021ObjectPropertyDto\210\001\000"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
      new com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public com.google.protobuf.ExtensionRegistry assignDescriptors(
            com.google.protobuf.Descriptors.FileDescriptor root) {
          descriptor = root;
          internal_static_ObjectPropertyProto_descriptor =
            getDescriptor().getMessageTypes().get(0);
          internal_static_ObjectPropertyProto_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessage.FieldAccessorTable(
              internal_static_ObjectPropertyProto_descriptor,
              new java.lang.String[] { "Category", "Properties", },
              fr.kissy.banshee.proto.ObjectPropertyDto.ObjectPropertyProto.class,
              fr.kissy.banshee.proto.ObjectPropertyDto.ObjectPropertyProto.Builder.class);
          return null;
        }
      };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          fr.kissy.hellion.proto.common.PropertyDto.getDescriptor(),
        }, assigner);
  }
  
  // @@protoc_insertion_point(outer_class_scope)
}
