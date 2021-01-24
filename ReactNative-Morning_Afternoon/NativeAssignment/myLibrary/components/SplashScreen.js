import React, { useEffect } from 'react';
import { View, Image, Text } from "react-native";

const SplashScreen = ({ navigation }) => {

    const showSplash = (
        <View style={{ flex: 1, alignItems: 'center', justifyContent: 'center' }}>
            <Text style={{ fontSize: 30, margin: 10 }}>
                Welcome to myLibrary
            </Text>
            <Image
                style={{ width: 300, height: 300 }}
                source={require('../assets/book.png')} />
        </View>
    )

    useEffect(() => {
        setTimeout(() => { navigation.navigate('ListScreen') }, 3000)
    }, []);

    return showSplash;

}

export default SplashScreen;