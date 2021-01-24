import * as React from 'react';
// import AppRegistry from 'react-native';
import { NavigationContainer } from '@react-navigation/native';
import { createStackNavigator } from '@react-navigation/stack';

import ListScreen from './components/ListScreen';
import BookDetails from './components/BookDetails';
import SplashScreen from './components/SplashScreen';

const Stack = createStackNavigator();

const App = () => {

  return (
    <NavigationContainer>
      <Stack.Navigator initialRouteName="Splash">

        <Stack.Screen
          name="Splash"
          component={SplashScreen}
          options={{ title: 'My Library' }}
        />

        <Stack.Screen
          name="ListScreen"
          component={ListScreen}
          options={{
            title: 'Books List', headerLeft: null, bottomBar: {
              backButton: {},
            }
          }}
        />

        <Stack.Screen
          name="Details"
          component={BookDetails}
          options={{ title: 'Book Details' }}
        />

      </Stack.Navigator>
    </NavigationContainer>
  );
};

export default App;