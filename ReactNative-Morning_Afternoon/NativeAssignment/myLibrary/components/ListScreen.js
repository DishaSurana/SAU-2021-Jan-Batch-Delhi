import React, { useEffect, useState, createRef } from 'react';
import { View, Text, SafeAreaView, StyleSheet, FlatList, TextInput, TouchableOpacity, Image, BackHandler } from "react-native";

const ListScreen = ({ navigation }) => {

    const [Data, updateData] = useState([]);
    const [origionalData, updateOrigionalData] = useState([]);
    const [isSorted, updateIsSorted] = useState(false);
    const [searchText, updateSearchText] = useState('');

    //Api for myLibrary books
    const url = "http://www.json-generator.com/api/json/get/cdXoyXpbCa?indent=2";

    useEffect(() => {
        BackHandler.addEventListener('hardwareBackPress', () => true);
        fetch(url)
            .then((response) => response.json())
            .then((responseJson) => {
                updateData(responseJson.Books);
                updateOrigionalData([...responseJson.Books]);
            })
    }, []);

    //Clear Search
    const clearSearch = () => {
        updateSearchText('');
        updateData([...origionalData]);
    }

    // toggle Sort function 'S'
    const toggleSort = () => {
        let sortedFlag = isSorted;
        if (sortedFlag === true) {
            sortedFlag = !sortedFlag;
            updateIsSorted(sortedFlag);
            updateData([...origionalData]);
        }
        else {
            let sortedList = [...Data];
            //sort on the basis of pageCount
            sortedList = sortedList.sort((a, b) => {
                return (a.pageCount - b.pageCount)
            });
            sortedFlag = !sortedFlag;
            updateIsSorted(sortedFlag);
            updateData(sortedList);
        }
    }

    const searchBooks = (text) => {
        updateSearchText(text);
        let newData = Data.filter((item) => {
            const itemData = item.title
                ? item.title.toUpperCase()
                : ''.toUpperCase();
            const textData = searchText.toUpperCase();
            return itemData.indexOf(textData) > -1;
        });
        updateData([...newData]);
    }

    //header stick screen
    const header = () => {
        return (
            <View style={styles.header}>
                <TextInput style={styles.textInput}
                    placeholder="Search"
                    value={searchText}
                    onChangeText={(text) => searchBooks(text)}
                ></TextInput>
                <TouchableOpacity style={styles.smallButton} onPress={clearSearch}>
                    <Text style={styles.smallButtonX}>X</Text>
                </TouchableOpacity>
                <TouchableOpacity style={styles.smallButton} onPress={toggleSort}>
                    <Text style={styles.smallButtonS}>S</Text>
                </TouchableOpacity>
            </View>
        );
    }

    //rendering a book's details
    let renderItem = ({ item }) => (
        <View style={styles.item}>
            <Image style={styles.image}
                source={{ uri: item.thumbnailUrl }}
            />
            <View style={{ flex: 1, flexDirection: 'column', justifyContent: 'space-between', alignItems: 'center' }}>
                <Text style={styles.title}>{item.title}</Text>
                <Text style={styles.author}>~ {item.authors}</Text>
                <TouchableOpacity style={styles.ViewButton}
                    onPress={() => navigation.navigate('Details', { title: item.title, information: item.shortDescription, img: item.thumbnailUrl })}>
                    <Text style={styles.viewButtonText}> More </Text>
                </TouchableOpacity>
            </View>
        </View>
    );

    return (
        <SafeAreaView style={styles.container}>
            <FlatList
                data={Data}
                renderItem={renderItem}
                ListHeaderComponent={header}
                stickyHeaderIndices={[0]}
                keyExtractor={(item, index) => item._id.toString()}
                ItemSeparatorComponent={() => <View style={{ width: "100%", height: 3, backgroundColor: "white" }}>
                </View>}
            />
        </SafeAreaView >
    );
}

export default ListScreen;


const styles = StyleSheet.create({
    container: {
        flex: 1,
        // marginTop: StatusBar.currentHeight || 0,
        backgroundColor: 'black',
    },
    header: {
        flex: 1,
        flexDirection: "row",
        justifyContent: "space-between",
        marginTop: 5,
        flexWrap: "wrap",
        backgroundColor: 'rgba(0,0,0,0.5)',
        padding: 3
    },
    item: {
        // padding: 20,
        marginVertical: 15,
        flex: 1,
        flexDirection: 'row',
        flexWrap: 'wrap',
        justifyContent: 'space-between',
        alignItems: 'center',
        backgroundColor: 'beige'
        // marginHorizontal: 16,
    },
    title: {
        fontSize: 22,
        color: 'black',
        textAlign: 'center',
        padding: 2,
        // fontFamily: 'Times',
        fontWeight: 'bold'
    },
    author: {
        fontSize: 18,
        color: 'black',
        textAlign: 'center',
        padding: 2,
    },
    image: {
        width: 200,
        height: 200,
    },
    textInput: {
        height: 50,
        width: 250,
        borderWidth: 2,
        borderRadius: 5,
        borderColor: "silver",
        textAlign: "center",
        // fontWeight: "bold",
        color: "black",
        backgroundColor: "white"
    },
    ViewButton:
    {
        borderWidth: 2,
        borderColor: "black",
        paddingVertical: 12,
        paddingHorizontal: 8,
        borderRadius: 5,
        backgroundColor: "green",
        marginVertical: 5
    },
    viewButtonText: {
        textAlign: "center",
        fontSize: 18,
        fontWeight: "bold",
        padding: 2
    },
    smallButtonX: {
        textAlign: "center",
        fontSize: 30,
        fontWeight: "bold",
        color: 'red',
        backgroundColor: 'white',
        paddingHorizontal: 10,
        marginTop: 4

    },
    smallButtonS: {
        textAlign: "center",
        fontSize: 30,
        fontWeight: "bold",
        color: 'green',
        backgroundColor: 'white',
        paddingHorizontal: 10,
        marginTop: 4

    }
});
