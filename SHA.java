import hashlib

def generate_sha1_hash(input_string):
    # object
    sha1_hash = hashlib.sha1()

    # encode with utf-8
    sha1_hash.update(input_string.encode('utf-8'))

    # hash in hex
    return sha1_hash.hexdigest()

if _name_ == "_main_":
    # input
    input_string = input("Enter a string to hash using SHA-1: ")
    
    # result
    result = generate_sha1_hash(input_string)

    # O/P
    print(f"SHA-1 Hash of '{input_string}': {result}")