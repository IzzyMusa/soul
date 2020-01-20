import React, { Component } from 'react';
import { ImageBackground, Alert, StyleSheet, Text, TextInput, View, Button, TouchableHighlight, TouchableOpacity, TouchableNativeFeedback, TouchableWithoutFeedback, Platform } from 'react-native';
import background from './assets/background.png';
const styles = StyleSheet.create({
    bigBlue: {
        flex: 5,
        color: 'blue',
        fontWeight: 'bold',
    },
    red: {
        color: 'red',
    },
    container: {
        paddingTop: 60,
        alignItems: 'center'
    },
    buttonContainer: {
    },
    alternativeLayoutButtonContainer: {
        flexDirection: 'row',
        justifyContent: 'space-between'
    },
    button: {
        width: 260,
        alignItems: 'center',
        backgroundColor: '#2196F3'
    },
    buttonText: {
        color: 'white'
    },
    imgBackground: {
        width: '100%',
        height: '100%',
    },
});

class Blink extends Component {

    componentDidMount() {
        // Toggle the state every second
        setInterval(() => (
            this.setState(previousState => (
                { isShowingText: !previousState.isShowingText }
            ))
        ), 1000);
    }

    //state object
    state = { isShowingText: true };

    render() {
        if (!this.state.isShowingText) {
            return null;
        }

        return (
            <Text style={[styles.bigBlue, styles.red]}>{this.props.text}</Text>
        );
    }
}
// flexDirection: 'row', 'row-reverse','column','column-reverse'
export default class BlinkApp extends Component {
    constructor(props) {
        super(props);
        this.state = { text: '' };
    }

    _onPressButton() {
        Alert.alert('You tapped the button!')
    }

    _onLongPressButton() {
        Alert.alert('You long-pressed the button!')
    }

    render() {
        return (
            <ImageBackground style={styles.imgBackground}
                resizeMode='stretch'
                source={background}>
            </ImageBackground>
        );
    }
}