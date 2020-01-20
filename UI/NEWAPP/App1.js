import React, { Component } from 'react';
import { Alert, StyleSheet, Text, TextInput, View, Button, TouchableHighlight, TouchableOpacity, TouchableNativeFeedback, TouchableWithoutFeedback, Platform } from 'react-native';


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
    }
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
            <View style={{ flex: 2, justifyContent: 'space-between', backgroundColor: 'black'}}>
                <View style={{ flex: 1, backgroundColor: 'black' }}>
                </View>
                <View style={{ flex: 9, backgroundColor: 'white' }}>
                    <View style={{ flex: 1, alignItems: 'center'}}>
                        <Blink text='Yes blinking is so great' />
                        <Text style={styles.bigBlue}>just bigBlue</Text>
                    </View>
                    <View style={{ flex: 1, alignItems: 'center'}}>
                        <Text style={[styles.bigBlue, styles.red]}>bigBlue, then red</Text>
                        <Text style={[styles.red, styles.bigBlue]}>red, then bigBlue</Text>
                    </View>
                    <View style={{ flex: 1, alignItems: 'center'}}>
                        <TextInput
                            style={{ height: 40 }}
                            placeholder="Type here to translate!"
                            onChangeText={(text) => this.setState({ text })}
                            value={this.state.text}
                        />
                        <Text style={{ padding: 10, fontSize: 42 }}>
                            {this.state.text.split(' ').map((word) => word && '🍕').join(' ')}
                        </Text>
                    </View>
                </View>
                <View style={{ flex: 9, backgroundColor: 'purple' }}>
                    <TouchableHighlight onPress={this._onPressButton} underlayColor="white">
                        <View style={styles.button}>
                            <Text style={styles.buttonText}>TouchableHighlight</Text>
                        </View>
                    </TouchableHighlight>
                    <TouchableOpacity onPress={this._onPressButton}>
                        <View style={styles.button}>
                            <Text style={styles.buttonText}>TouchableOpacity</Text>
                        </View>
                    </TouchableOpacity>
                    <TouchableNativeFeedback
                        onPress={this._onPressButton}
                        background={Platform.OS === 'android' ? TouchableNativeFeedback.SelectableBackground() : ''}>
                        <View style={styles.button}>
                            <Text style={styles.buttonText}>TouchableNativeFeedback</Text>
                        </View>
                    </TouchableNativeFeedback>
                    <TouchableWithoutFeedback
                        onPress={this._onPressButton}
                    >
                        <View style={styles.button}>
                            <Text style={styles.buttonText}>TouchableWithoutFeedback</Text>
                        </View>
                    </TouchableWithoutFeedback>
                    <TouchableHighlight onPress={this._onPressButton} onLongPress={this._onLongPressButton} underlayColor="white">
                        <View style={styles.button}>
                            <Text style={styles.buttonText}>Touchable with Long Press</Text>
                        </View>
                    </TouchableHighlight>
                 </View>
            </View>
        );
    }
}