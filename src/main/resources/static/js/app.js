document.addEventListener('click', e=>{
  document.querySelectorAll('.dropdown-menu')
          .forEach(m=>m.classList.add('hidden'));
});

function openCompanyModal(id='', name='') {
  // …
}
function openBranchModal(id='', name='', companyId='') {
  // …
}
function closeModal(id) {
  document.getElementById(id)
          .classList.add('opacity-0','pointer-events-none');
}
// … любые другие повторяющиеся утилиты
