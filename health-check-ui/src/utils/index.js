
/**
 * @description setHours
 * @desc 24 hours after getting from the current hour
 * @param {string} time start Time
 * @return {Array<number>}
 * */
export function setHours(time) {
  let minute = time.split(" ")[1].split(":")[1];
  let hour = time.split(" ")[1].split(":")[0];
  let hours = [];
  for (let i = 0; i < 24; i++) {
    if (i + Number(hour) >= 24) {
      hours.push(i + Number(hour) - 24 + ":" + minute);
    } else {
      hours.push(i + Number(hour) + ":" + minute);
    }
  }
  hours.map((item, index) => {
    if (item.split(":")[0].length === 1) {
      hours[index] = "0" + item;
    }
  });

  return hours;
}

/**
 * @description setHours
 * @desc 24 hours after getting from the current hour
 * @param {string} time start Time
 * @return {Array<number>}
 * */
export function getHours(time) {
  let date = new Date(time).getTime();
  let hours = [];
  for (let i = 0; i < 24; i++) {
    hours.push(date + i * (1000 * 60 * 60));
  }
  return hours;
}


export function getRequireRule() {
  return [
    { required: true, message: '请填写此项', trigger: 'blur' }
  ]
}

export function _toCamel (string) {
  return string.replace(/_(\w)/g, function (all, letter) {
    return letter.toUpperCase();
  });
}