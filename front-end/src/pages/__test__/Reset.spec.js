require('chai').should()

import React from 'react/addons'
import Reset from '../Reset.react.js'

const TestUtils = React.addons.TestUtils

let reset
describe('Reset Page Component', function() {
    before(function() {
        reset = TestUtils.renderIntoDocument(<Reset />)
    });
    it('should be able to initialized independently', function() {
        TestUtils.isCompositeComponent(reset).should.be.equal(true)
        TestUtils.isCompositeComponentWithType(reset, Reset)
    });
    it('should be disable to click reset when new password or confirm password in short length', function() {
        reset.refs.newPassword.setValue('1234567');
        reset.refs.confirmPassword.setValue('1234567');
        reset.onInputed();
        reset.state.disabled.should.be.true;
        reset.refs.newPassword.setValue('12345678');
        reset.refs.confirmPassword.setValue('12345678');
        reset.onInputed();
        reset.state.disabled.should.be.false;
    });
    it('should not be reset when confirm password is different with new password', function() {
        reset.refs.newPassword.setValue('12345678');
        reset.refs.confirmPassword.setValue('12345671');
        reset._reset();
        reset.state.confirmPasswordError.should.be.equal('The confirm password should be equal to new password.');
    });
})
