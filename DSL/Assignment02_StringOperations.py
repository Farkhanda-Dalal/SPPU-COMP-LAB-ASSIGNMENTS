class StringOperations:

    def __init__(self):
        self.sent = None
        self.sent_length = None
        self.search_char = None
        self.search_substring = None
        self.words = []
        self.num_words = 0

    def take_input( self ):
        self.sent = input( "Enter a sentence : " )
        self.search_char = input( "Enter a character to find its frequency : " )
        self.search_substring = input( "Enter a substring to search in the given sentence : " )
        self.sent_length = self.get_length( self.sent )

    def get_length( self , s ):
        index = 0
        for _ in s:
            index = index + 1
        return index

    def reverse( self , s ):
        output = ""
        for i in range( self.get_length( s ) - 1 , -1 , -1 ):
            output += s[ i ]
        return output

    def get_unique_words( self , words ):
        output = []
        for word in words:
            if word not in output:
                output.append( word )
        return output

    def get_longest_word( self ):
        words = []
        word_lengths = []
        char_index = 0
        prev_word_index = 0
        num_words = 0
        for char in self.sent:
            if char == " ":
                words.append( self.sent[ prev_word_index : char_index] )
                word_lengths.append( char_index - prev_word_index )
                num_words += 1
                # Skip the " " char here
                prev_word_index = char_index + 1
            elif char_index == self.sent_length - 1:
                words.append( self.sent[ prev_word_index : char_index + 1 ] )
                word_lengths.append( char_index - prev_word_index )
                num_words += 1
            char_index += 1

        self.words = words
        self.num_words = num_words
        # Get index of greatest element in word_lengths
        max = -1
        max_index = 0
        length_index = 0
        for length in word_lengths:
            if length > max:
                max = length
                max_index = length_index
            length_index += 1
        return words[ max_index ]

    def get_char_frequency( self ):
        frequency = 0
        for char in self.sent:
            if char == self.search_char:
                frequency += 1
        return frequency

    def find_substring( self ):
        substring_length = self.get_length( self.search_substring )
        for char_index in range( self.sent_length ):
            if self.sent[ char_index : char_index + substring_length ] == self.search_substring:
                return char_index
        return -1

    def is_palindrome( self ):
        reverse_sent = self.reverse( self.sent )
        return reverse_sent == self.sent

    def find_occurrences( self ):
        word_counts = []
        unique_words = self.get_unique_words( self.words )
        for search_word in unique_words:
            count = 0
            for word in self.words:
                if search_word == word:
                    count += 1
            word_counts.append( count )
        return unique_words , word_counts


str_ops = StringOperations()
str_ops.take_input()

longest_word = str_ops.get_longest_word()
print( 'Longest word in given sentence is :' , longest_word )

char_freq = str_ops.get_char_frequency()
print( 'Frequency of given character in the sentence is :' , char_freq )

substring_index = str_ops.find_substring()
if substring_index == -1:
    print( 'Given substring was not found in the sentence' )
else:
    print( 'Given substring starts from {}th character in the sentence'.format( substring_index + 1 ) )

if str_ops.is_palindrome():
    print( 'Given string is a palindrome' )
else:
    print( 'Given string is not a palindrome' )

print( "Word frequencies : ")
words , counts = str_ops.find_occurrences()
i = 0
for word in words:
    print( 'Frequency of word {} in given sentence is {}'.format( word , counts[i] ) )
    i += 1


