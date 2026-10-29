// Age is calculated in the visitor's local calendar date on each page load.
const birthDate = '2003-05-29';

function updateAge(dateString) {
  if (!dateString) return;
  const match = /^(\d{4})-(\d{2})-(\d{2})$/.exec(dateString);
  if (!match) return;
  const year = Number(match[1]);
  const month = Number(match[2]);
  const day = Number(match[3]);
  const valid = new Date(year, month - 1, day);
  if (valid.getFullYear() !== year || valid.getMonth() !== month - 1 || valid.getDate() !== day) return;
  const today = new Date();
  let age = today.getFullYear() - year;
  if (today.getMonth() + 1 < month || (today.getMonth() + 1 === month && today.getDate() < day)) age--;
  if (age < 0) return;
  document.getElementById('age-value').textContent = `${age} years old`;
  document.getElementById('age-row').style.display = 'flex';
}

updateAge(birthDate);
document.getElementById('year').textContent = new Date().getFullYear();

async function loadLatestProjects() {
  const container = document.getElementById('latest-projects');
  try {
    const response = await fetch('https://api.github.com/users/pogiko1345/repos?per_page=100&sort=updated', { headers: { Accept: 'application/vnd.github+json' } });
    if (!response.ok) throw new Error(`GitHub returned ${response.status}`);
    const repositories = (await response.json()).filter(repo => !repo.fork && !repo.archived && repo.name !== 'About-Me').slice(0, 3);
    if (!repositories.length) throw new Error('No repositories found');
    container.replaceChildren(...repositories.map(repo => {
      const card = document.createElement('article');
      card.className = 'latest-card';
      const heading = document.createElement('h3');
      heading.textContent = repo.name.replace(/[-_]/g, ' ');
      const description = document.createElement('p');
      description.textContent = repo.description || 'Explore the source and recent changes on GitHub.';
      const link = document.createElement('a');
      link.href = repo.html_url;
      link.target = '_blank';
      link.rel = 'noopener noreferrer';
      link.textContent = 'View repository ↗';
      const updated = document.createElement('small');
      updated.textContent = `Updated ${new Date(repo.updated_at).toLocaleDateString(undefined, { year: 'numeric', month: 'short', day: 'numeric' })}`;
      card.append(heading, description, link, updated);
      return card;
    }));
  } catch {
    container.replaceChildren();
    const fallback = document.createElement('p');
    fallback.className = 'loading';
    fallback.textContent = 'Recent projects are temporarily unavailable. See all my work on GitHub.';
    container.append(fallback);
  }
}

loadLatestProjects();
