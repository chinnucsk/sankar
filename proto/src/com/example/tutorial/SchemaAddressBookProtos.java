// Generated by http://code.google.com/p/protostuff/ ... DO NOT EDIT!
// Generated from addressbook.proto

package com.example.tutorial;


public final class SchemaAddressBookProtos
{

    public static final class Person
    {

        public static final class PhoneNumber
        {
            public static final com.example.tutorial.SchemaAddressBookProtos.Person.PhoneNumber.MessageSchema WRITE =
                new com.example.tutorial.SchemaAddressBookProtos.Person.PhoneNumber.MessageSchema();
            public static final com.example.tutorial.SchemaAddressBookProtos.Person.PhoneNumber.BuilderSchema MERGE =
                new com.example.tutorial.SchemaAddressBookProtos.Person.PhoneNumber.BuilderSchema();
            
            public static class MessageSchema implements com.dyuproject.protostuff.Schema<com.example.tutorial.AddressBookProtos.Person.PhoneNumber>
            {
                public void writeTo(com.dyuproject.protostuff.Output output, com.example.tutorial.AddressBookProtos.Person.PhoneNumber message) throws java.io.IOException
                {
                    if(message.hasNumber())
                        output.writeString(1, message.getNumber(), false);
                    if(message.hasType())
                        output.writeEnum(2, message.getType().getNumber(), false);
                }
                public boolean isInitialized(com.example.tutorial.AddressBookProtos.Person.PhoneNumber message)
                {
                    return message.isInitialized();
                }
                public java.lang.String getFieldName(int number)
                {
                    return com.example.tutorial.SchemaAddressBookProtos.Person.PhoneNumber.getFieldName(number);
                }
                public int getFieldNumber(java.lang.String name)
                {
                    return com.example.tutorial.SchemaAddressBookProtos.Person.PhoneNumber.getFieldNumber(name);
                }
                public java.lang.Class<com.example.tutorial.AddressBookProtos.Person.PhoneNumber> typeClass()
                {
                    return com.example.tutorial.AddressBookProtos.Person.PhoneNumber.class;
                }
                public java.lang.String messageName()
                {
                    return com.example.tutorial.AddressBookProtos.Person.PhoneNumber.class.getSimpleName();
                }
                public java.lang.String messageFullName()
                {
                    return com.example.tutorial.AddressBookProtos.Person.PhoneNumber.class.getName();
                }
                //unused
                public void mergeFrom(com.dyuproject.protostuff.Input input, com.example.tutorial.AddressBookProtos.Person.PhoneNumber message) throws java.io.IOException {}
                public com.example.tutorial.AddressBookProtos.Person.PhoneNumber newMessage() { return null; }
            }
            public static class BuilderSchema implements com.dyuproject.protostuff.Schema<com.example.tutorial.AddressBookProtos.Person.PhoneNumber.Builder>
            {
                public void mergeFrom(com.dyuproject.protostuff.Input input, com.example.tutorial.AddressBookProtos.Person.PhoneNumber.Builder builder) throws java.io.IOException
                {
                    for(int number = input.readFieldNumber(this);; number = input.readFieldNumber(this))
                    {
                        switch(number)
                        {
                            case 0:
                                return;
                            case 1:
                                builder.setNumber(input.readString());
                                break;
                            case 2:
                                builder.setType(com.example.tutorial.AddressBookProtos.Person.PhoneType.valueOf(input.readEnum()));
                                break;
                            default:
                                input.handleUnknownField(number, this);
                        }
                    }
                }
                public boolean isInitialized(com.example.tutorial.AddressBookProtos.Person.PhoneNumber.Builder builder)
                {
                    return builder.isInitialized();
                }
                public com.example.tutorial.AddressBookProtos.Person.PhoneNumber.Builder newMessage()
                {
                    return com.example.tutorial.AddressBookProtos.Person.PhoneNumber.newBuilder();
                }
                public java.lang.String getFieldName(int number)
                {
                    return com.example.tutorial.SchemaAddressBookProtos.Person.PhoneNumber.getFieldName(number);
                }
                public int getFieldNumber(java.lang.String name)
                {
                    return com.example.tutorial.SchemaAddressBookProtos.Person.PhoneNumber.getFieldNumber(name);
                }
                public java.lang.Class<com.example.tutorial.AddressBookProtos.Person.PhoneNumber.Builder> typeClass()
                {
                    return com.example.tutorial.AddressBookProtos.Person.PhoneNumber.Builder.class;
                }
                public java.lang.String messageName()
                {
                    return com.example.tutorial.AddressBookProtos.Person.PhoneNumber.class.getSimpleName();
                }
                public java.lang.String messageFullName()
                {
                    return com.example.tutorial.AddressBookProtos.Person.PhoneNumber.class.getName();
                }
                //unused
                public void writeTo(com.dyuproject.protostuff.Output output, com.example.tutorial.AddressBookProtos.Person.PhoneNumber.Builder builder) throws java.io.IOException {}
            }
            public static java.lang.String getFieldName(int number)
            {
                return java.lang.String.valueOf(number);
            }
            public static int getFieldNumber(java.lang.String name)
            {
                return java.lang.Integer.parseInt(name);
            }

        }

        public static final com.example.tutorial.SchemaAddressBookProtos.Person.MessageSchema WRITE =
            new com.example.tutorial.SchemaAddressBookProtos.Person.MessageSchema();
        public static final com.example.tutorial.SchemaAddressBookProtos.Person.BuilderSchema MERGE =
            new com.example.tutorial.SchemaAddressBookProtos.Person.BuilderSchema();
        
        public static class MessageSchema implements com.dyuproject.protostuff.Schema<com.example.tutorial.AddressBookProtos.Person>
        {
            public void writeTo(com.dyuproject.protostuff.Output output, com.example.tutorial.AddressBookProtos.Person message) throws java.io.IOException
            {
                if(message.hasName())
                    output.writeString(1, message.getName(), false);
                if(message.hasId())
                    output.writeInt32(2, message.getId(), false);
                if(message.hasEmail())
                    output.writeString(3, message.getEmail(), false);
                for(com.example.tutorial.AddressBookProtos.Person.PhoneNumber phone : message.getPhoneList())
                    output.writeObject(4, phone, com.example.tutorial.SchemaAddressBookProtos.Person.PhoneNumber.WRITE, true);

            }
            public boolean isInitialized(com.example.tutorial.AddressBookProtos.Person message)
            {
                return message.isInitialized();
            }
            public java.lang.String getFieldName(int number)
            {
                return com.example.tutorial.SchemaAddressBookProtos.Person.getFieldName(number);
            }
            public int getFieldNumber(java.lang.String name)
            {
                return com.example.tutorial.SchemaAddressBookProtos.Person.getFieldNumber(name);
            }
            public java.lang.Class<com.example.tutorial.AddressBookProtos.Person> typeClass()
            {
                return com.example.tutorial.AddressBookProtos.Person.class;
            }
            public java.lang.String messageName()
            {
                return com.example.tutorial.AddressBookProtos.Person.class.getSimpleName();
            }
            public java.lang.String messageFullName()
            {
                return com.example.tutorial.AddressBookProtos.Person.class.getName();
            }
            //unused
            public void mergeFrom(com.dyuproject.protostuff.Input input, com.example.tutorial.AddressBookProtos.Person message) throws java.io.IOException {}
            public com.example.tutorial.AddressBookProtos.Person newMessage() { return null; }
        }
        public static class BuilderSchema implements com.dyuproject.protostuff.Schema<com.example.tutorial.AddressBookProtos.Person.Builder>
        {
            public void mergeFrom(com.dyuproject.protostuff.Input input, com.example.tutorial.AddressBookProtos.Person.Builder builder) throws java.io.IOException
            {
                for(int number = input.readFieldNumber(this);; number = input.readFieldNumber(this))
                {
                    switch(number)
                    {
                        case 0:
                            return;
                        case 1:
                            builder.setName(input.readString());
                            break;
                        case 2:
                            builder.setId(input.readInt32());
                            break;
                        case 3:
                            builder.setEmail(input.readString());
                            break;
                        case 4:
                            builder.addPhone(input.mergeObject(com.example.tutorial.AddressBookProtos.Person.PhoneNumber.newBuilder(), com.example.tutorial.SchemaAddressBookProtos.Person.PhoneNumber.MERGE));

                            break;
                        default:
                            input.handleUnknownField(number, this);
                    }
                }
            }
            public boolean isInitialized(com.example.tutorial.AddressBookProtos.Person.Builder builder)
            {
                return builder.isInitialized();
            }
            public com.example.tutorial.AddressBookProtos.Person.Builder newMessage()
            {
                return com.example.tutorial.AddressBookProtos.Person.newBuilder();
            }
            public java.lang.String getFieldName(int number)
            {
                return com.example.tutorial.SchemaAddressBookProtos.Person.getFieldName(number);
            }
            public int getFieldNumber(java.lang.String name)
            {
                return com.example.tutorial.SchemaAddressBookProtos.Person.getFieldNumber(name);
            }
            public java.lang.Class<com.example.tutorial.AddressBookProtos.Person.Builder> typeClass()
            {
                return com.example.tutorial.AddressBookProtos.Person.Builder.class;
            }
            public java.lang.String messageName()
            {
                return com.example.tutorial.AddressBookProtos.Person.class.getSimpleName();
            }
            public java.lang.String messageFullName()
            {
                return com.example.tutorial.AddressBookProtos.Person.class.getName();
            }
            //unused
            public void writeTo(com.dyuproject.protostuff.Output output, com.example.tutorial.AddressBookProtos.Person.Builder builder) throws java.io.IOException {}
        }
        public static java.lang.String getFieldName(int number)
        {
            return java.lang.String.valueOf(number);
        }
        public static int getFieldNumber(java.lang.String name)
        {
            return java.lang.Integer.parseInt(name);
        }

    }

    public static final class AddressBook
    {
        public static final com.example.tutorial.SchemaAddressBookProtos.AddressBook.MessageSchema WRITE =
            new com.example.tutorial.SchemaAddressBookProtos.AddressBook.MessageSchema();
        public static final com.example.tutorial.SchemaAddressBookProtos.AddressBook.BuilderSchema MERGE =
            new com.example.tutorial.SchemaAddressBookProtos.AddressBook.BuilderSchema();
        
        public static class MessageSchema implements com.dyuproject.protostuff.Schema<com.example.tutorial.AddressBookProtos.AddressBook>
        {
            public void writeTo(com.dyuproject.protostuff.Output output, com.example.tutorial.AddressBookProtos.AddressBook message) throws java.io.IOException
            {
                for(com.example.tutorial.AddressBookProtos.Person person : message.getPersonList())
                    output.writeObject(1, person, com.example.tutorial.SchemaAddressBookProtos.Person.WRITE, true);

            }
            public boolean isInitialized(com.example.tutorial.AddressBookProtos.AddressBook message)
            {
                return message.isInitialized();
            }
            public java.lang.String getFieldName(int number)
            {
                return com.example.tutorial.SchemaAddressBookProtos.AddressBook.getFieldName(number);
            }
            public int getFieldNumber(java.lang.String name)
            {
                return com.example.tutorial.SchemaAddressBookProtos.AddressBook.getFieldNumber(name);
            }
            public java.lang.Class<com.example.tutorial.AddressBookProtos.AddressBook> typeClass()
            {
                return com.example.tutorial.AddressBookProtos.AddressBook.class;
            }
            public java.lang.String messageName()
            {
                return com.example.tutorial.AddressBookProtos.AddressBook.class.getSimpleName();
            }
            public java.lang.String messageFullName()
            {
                return com.example.tutorial.AddressBookProtos.AddressBook.class.getName();
            }
            //unused
            public void mergeFrom(com.dyuproject.protostuff.Input input, com.example.tutorial.AddressBookProtos.AddressBook message) throws java.io.IOException {}
            public com.example.tutorial.AddressBookProtos.AddressBook newMessage() { return null; }
        }
        public static class BuilderSchema implements com.dyuproject.protostuff.Schema<com.example.tutorial.AddressBookProtos.AddressBook.Builder>
        {
            public void mergeFrom(com.dyuproject.protostuff.Input input, com.example.tutorial.AddressBookProtos.AddressBook.Builder builder) throws java.io.IOException
            {
                for(int number = input.readFieldNumber(this);; number = input.readFieldNumber(this))
                {
                    switch(number)
                    {
                        case 0:
                            return;
                        case 1:
                            builder.addPerson(input.mergeObject(com.example.tutorial.AddressBookProtos.Person.newBuilder(), com.example.tutorial.SchemaAddressBookProtos.Person.MERGE));

                            break;
                        default:
                            input.handleUnknownField(number, this);
                    }
                }
            }
            public boolean isInitialized(com.example.tutorial.AddressBookProtos.AddressBook.Builder builder)
            {
                return builder.isInitialized();
            }
            public com.example.tutorial.AddressBookProtos.AddressBook.Builder newMessage()
            {
                return com.example.tutorial.AddressBookProtos.AddressBook.newBuilder();
            }
            public java.lang.String getFieldName(int number)
            {
                return com.example.tutorial.SchemaAddressBookProtos.AddressBook.getFieldName(number);
            }
            public int getFieldNumber(java.lang.String name)
            {
                return com.example.tutorial.SchemaAddressBookProtos.AddressBook.getFieldNumber(name);
            }
            public java.lang.Class<com.example.tutorial.AddressBookProtos.AddressBook.Builder> typeClass()
            {
                return com.example.tutorial.AddressBookProtos.AddressBook.Builder.class;
            }
            public java.lang.String messageName()
            {
                return com.example.tutorial.AddressBookProtos.AddressBook.class.getSimpleName();
            }
            public java.lang.String messageFullName()
            {
                return com.example.tutorial.AddressBookProtos.AddressBook.class.getName();
            }
            //unused
            public void writeTo(com.dyuproject.protostuff.Output output, com.example.tutorial.AddressBookProtos.AddressBook.Builder builder) throws java.io.IOException {}
        }
        public static java.lang.String getFieldName(int number)
        {
            return java.lang.String.valueOf(number);
        }
        public static int getFieldNumber(java.lang.String name)
        {
            return java.lang.Integer.parseInt(name);
        }

    }

}
