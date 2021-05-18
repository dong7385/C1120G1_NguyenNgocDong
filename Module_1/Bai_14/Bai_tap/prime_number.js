function isFrimeNumber(checknumber) {

    let count = 0;

    for (let i = 1; i <= checknumber; i++) {
        if (checknumber % i === 0) {
            count++;
        }
    }
    if (count === 2) {
        return true;
    }
    return false;
}
