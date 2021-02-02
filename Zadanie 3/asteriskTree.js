function createTree() {
    const rows = document.querySelector('#rowsNumber').value
    createAsteriskTree(rows)
}

function createAsteriskTree(rows) {
    if (isInputValid(rows)) {
        drawRow(1, rows)
    }
}

const isInputValid = (number) => !isNaN(number) && number > 0

const drawRow = (currentRow, maxRows) => {
    if (currentRow <= maxRows) {
        const rowString = createRowString(maxRows, currentRow);
        console.log(rowString)
        drawRow(++currentRow, maxRows)
    }
}

const createRowString = (maxRows, currentRow) => {
    const spacesString = appendSpaces(maxRows, currentRow)
    const asteriskString = appendAsterisks(currentRow)
    return spacesString + asteriskString;
}

const appendSpaces = (maxRows, currentRow) => Array(calculateSpaces(maxRows, currentRow)).join(' ')

const appendAsterisks = (row) => Array(calculateAsterisks(row) + 1).join("*")

const calculateSpaces = (max, current) => (max - current) + 1

const calculateAsterisks = (n) => (n + (n - 1))