import React from 'react';
import { View, Text, Image, Button, Linking } from 'react-native';
import { TouchableOpacity } from 'react-native-gesture-handler';

export default BookDetails = ({ route, navigation }) => {

    const { information, title, img } = route.params;

    return (
        < View style={{ flex: 1, flexDirection: 'column' }}>

            <Image source={{ uri: img }} style={{ height: 400, width: 400 }} />
            <Text style={{ padding: 3 }}>
                Details: {information}
            </Text>

            <Button title="Click to get Title"
                onPress={() => alert('You have pressed: ' + title)}></Button>

            <TouchableOpacity
                style={{ backgroundColor: 'green', padding: 10 }}
                onPress={() => Linking.openURL('https://www.accolite.com/')}>
                <Text style={{ textAlign: 'center', fontSize: 20, fontWeight: 'bold' }}>
                    Accolite
                </Text>
            </TouchableOpacity>
        </View >
    );
}